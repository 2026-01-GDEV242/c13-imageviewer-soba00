import java.awt.Color;

/**
 * An image filter to remove color from an image.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 1.0
 */
public class WarholFilter extends Filter
{
    //fields from SmoothFilter
    private OFImage original;
    private int width;
    private int height;
    
    /**
     * Constructor for objects of class WarholFilter.
     * @param name The name of the filter.
     */
    public WarholFilter(String name)
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
                Color pix = storedImage.getPixel(x * 2, y);
                Color red = new Color(pix.getRed(), 0, 0);
                Color green = new Color(0, pix.getGreen(), 0);
                Color blue = new Color(0, 0, pix.getBlue());
                
                //STEP 2: Repeat pixel's data in four places moddified accordingly
            
                //Q1- 
                image.setPixel(x, y, pix); //original image
                
                //Q2-
                image.setPixel(x+halfWidth, y, pix);
                
                //Q1- 
                image.setPixel(x, y, pix);
                
                //Q1- 
                image.setPixel(x, y, pix);
            }
            
        }
        
    }
    
}
