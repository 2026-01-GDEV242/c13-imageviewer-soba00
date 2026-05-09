import java.awt.Color;

/**
 * An image filter to tint and image blue.
 * 
 * @author Federico Cadavid Rojas
 * @version 1
 */
public class BlueTintFilter extends Filter
{
    /**
     * Constructor for objects of class BlueTintFilter.
     * @param name The name of the filter.
     */
    public BlueTintFilter(String name)
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
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int color = pix.getBlue();
                image.setPixel(x, y, new Color(0, 0, color));
            }
        }
    }
}
