#!/usr/bin/env python3
"""
Jewelry image Processor
=======================
Automated image processing tool for jewelry catalog product photos.

Features:
-Removes backgrounds from product images
-Adds consistent white/light gray background
-Standardizes image dimenstions
-Batch processes entire folders
-Preserves original filenames

Author: Kaung Min Khant
Project: Atelier D'Excellence Private Jewelry Catalog
"""
import os
from pathlib import Path
from PIL import Image, ImageDraw, ImageFilter
from rembg import remove
import argparse

class JewelryImageProcessor:
    """Process jewelry images with background removal and standardization"""

    def __init__(self, output_size=(800, 800), background_color='white'):
        """
        Initialize the image processor.

        Args:
            output_size(tuple): targe dimensions(width, height) in pixels
            background_color (str): Background color ('white', 'lightgray', or hex code
        """
        self.output_size = output_size
        self.background_color = self._parse_color(background_color)


    def _parse_color(self, color_name):
        """Convert color name to RGB Tuple."""
        colors = {
            'white': (255, 255,255),
            'lightgray': (248, 248, 248),
            'beige': (250, 245, 235)
        }
        return colors.get(color_name.lower(), (255,255,255))

    def process_image(self, input_path, output_path):
        """Process a singe image: remove background, add new background, resize
        Args:
            input_path (str): Path to input image
            output_path (str): Path to save processed image

        Returns:
            bool: True if successful, false if otherwise
        """
        try:
            #open original image
            print(f"processing: {os.path.basename(input_path)}")
            input_image = Image.open(input_path)

            #remove background
            print(" -> Removing background....")
            output_image = remove(input_image)

            #create new background
            print( "-> Adding new background....")
            background = Image.new('RGB', self.output_size, self.background_color)

            #resize the image while maintaining aspect ratio
            output_image.thumbnail(self.output_size, Image.Resampling.LANCZOS)

            #center the image to the background
            offset_x = (self.output_size[0] - output_image.width) // 2
            offset_y = (self.output_size[1] - output_image.height) // 2

            #pase image onto background(using alpha channel as mask)
            background.paste(output_image, (offset_x,offset_y), output_image)

            #save processed image
            background.save(output_path, 'PNG', quality = 95)
            print(f" ✓ Saved: {os.path.basename(output_path)}")
            return True

        except Exception as e:
            print(f" ✗ Error Processing {os.path.basename(input_path)}: {str(e)}")
            return False



    def process_folder(self, input_folder, output_folder):
        """Process all images in a folder
        Args:
            input_folder (str): Path to folder with original images
            output_folder (str): Path to save processed images

        Returns:
            dict: Statistics about processing(success, failed, total)
        """

        #create output folder if it doesn't exist
        os.makedirs(output_folder, exist_ok=True)

        #supported image formats
        supported_formats = {'.jpg', '.jpeg', '.png', '.webp'}

        #find all image files
        input_path = Path(input_folder)
        image_files = [
            f for f in input_path.iterdir()
            if f.suffix.lower() in supported_formats
        ]
        if not image_files:
            print(f"No images found in {input_folder}")
            return {'total':0, 'success': 0, 'failed': 0}

        print(f"\nFound {len(image_files)} images to process\n")
        print("=" * 60)

        #process each image
        stats = {'total':len(image_files), 'success': 0, 'failed': 0}

        for i, image_file in enumerate(image_files, 1):
            print(f"\n[{i}/{len(image_files)}]")

            input_path = str(image_file)
            output_filename = image_file.ste, + '.png' #save as PNG
            output_path = os.path.join(output_folder, output_filename)

            if self.process_image(input_path, output_path):
                stats['success'] += 1

            else:
                stats['failed'] += 1


        return stats

def main():
    """Main Function to run the image processor from command line."""
    parser = argparse.ArgumentParser(
        description='Process jewelry images with background removal and standardization.',
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
        Examples:
        #Process all images in folder
        python jewelry_image_processor.py -i ./raw_images -o ./processed_images
        
        #Use custom size and background
        python jewelry_image_processor.py -i ./raw_images -o ./processed_images -s 1000 -b lightgray
        
        #Process a singel image
        python jewelry_image_processor.py -i ring.png -o ring_processed.png
        """
    )

    parser.add_argument('-i', '--input', required=True,
                       help = 'Input image file or folder')
    parser.add_argument('-o', '--output', required=True,
                        help='Output image file or folder')
    parser.add_argument('-s', '--size', type=int, default=800,
                        help='Output image size in pixels (default: 800)')
    parser.add_argument('-b', '--background', default='white',
                        choices=['white', 'lightgray', 'beige'],
                        help='Background color (default: white)')

    args = parser.parse_args()

    #Initialize processor
    processor = JewelryImageProcessor(
    output_size = (args.size, args.size),
    background_color = args.background
    )

    #Check if input is a file or folder
    input_path = Path(args.input)

    if input_path.is_file():
        # Process single file
        print("\n" + "=" * 60)
        print("JEWELRY IMAGE PROCESSOR - Single Image Mode")
        print("=" * 60)
        processor.process_image(args.input, args.output)
        print("\n✓ Processing complete!")

    elif input_path.is_dir():
        # Process folder
        print("\n" + "=" * 60)
        print("JEWELRY IMAGE PROCESSOR - Batch Mode")
        print("=" * 60)
        stats = processor.process_folder(args.input, args.output)

        # Print summary
        print("\n" + "=" * 60)
        print("PROCESSING SUMMARY")
        print("=" * 60)
        print(f"Total images: {stats['total']}")
        print(f"✓ Successful: {stats['success']}")
        print(f"✗ Failed: {stats['failed']}")
        print(f"Success rate: {stats['success']/stats['total']*100:.1f}%")
        print("\n✓ All processing complete!")

    else:
        print(f"Error: '{args.input}' is not a valid file or folder")
        return 1

    return 0


if __name__ == "__main__":
    exit(main())





