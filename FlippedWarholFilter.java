import java.awt.Color;

/**
 * Warhol-style image filter that splits an image into four quadrants.
 * The top-left quadrant shows the original image,
 * Other three quadrants display tinted versions (red, green, and blue) mirrored
 * about both axis.
 *
 *
 *
 * @author Federico Cadavid Rojas
 * @version 1
 */
public class FlippedWarholFilter extends Filter
{
    //fields from SmoothFilter
    private OFImage storedImage;
    private int width;
    private int height;
    
    /**
     * Constructor for objects of class FlippedWarholFilter.
     * @param name The name of the filter.
     */
    public FlippedWarholFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        //OFI Mage the Wise (Oracle Forseerer of Images)
        OFImage storedImage = new OFImage(image); //OFI (Oracle Forseerer of Images)  Mage the Wise 
        
        int height = image.getHeight();
        int width = image.getWidth();
        
        //needed for analyzing quadrant set ahead of time to reduce method calls
        int halfHeight = height / 2;
        int halfWidth = width / 2;
        
        
        for(int y = 0; y < halfHeight; y++) {
            for(int x = 0; x < halfWidth; x++) {
                
                //STEP 1: Get color data of single shrunken image pixel
                Color pix = storedImage.getPixel(x * 2, y * 2);
                //tinted versions of shrunken pixel
                Color redTint = new Color(pix.getRed(), 0, 0);
                Color greenTint = new Color(0, pix.getGreen(), 0);
                Color blueTint = new Color(0, 0, pix.getBlue());
                
                //STEP 2: Repeat pixel's data in four places moddified accordingly
            
                
                //Q1 (TOP RIGHT)-
                image.setPixel(width - 1 - x, y, redTint); //red tint image
                
                //Q2- (TOP LEFT)
                image.setPixel(x, y, pix); //original image
                
                //Q3- (BOTTOM LEFT)
                image.setPixel(x, height - 1 - y, greenTint); //green tint image
                
                //Q4 (BOTTOM RIGHT)- 
                image.setPixel(width - 1 - x, height - 1 - y, blueTint); //blue tint
            }
            
        }
        
    }
    
}
