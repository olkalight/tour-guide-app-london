package com.example.tourguideapplondon;


public class Item {

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Image resource ID for the item
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /**
     * string resource ID for item name
     */
    private String mAttractionName;
    /**
     * string resource ID for item description
     */
    private String mAttractionDescription;
    /**
     * check if the item has description
     */
    private boolean hasDescription;
    /**
     * latitude of the item
     */
    private double mLatitude;
    /**
     * longitude of the item
     */
    private double mLongitude;
    /**
     * map Image resource ID for the item
     */
    private int mMapButton;

    /**
     * Create a new Item object.
     *
     * @param attractionName        is the string resource ID for the item name
     * @param attractionDescription is the string resource Id for the item description
     * @param imageResourceId       is the drawable resource ID for the image associated with the item
     * @param latitude              is the resource ID for the latitude of the item
     * @param longitude             is the resource ID for the longitude of the item
     * @param mapButton             is the drawable resource ID for the icon associated with the item
     */
    public Item(String attractionName, String attractionDescription, int imageResourceId,
                double latitude, double longitude, int mapButton) {
        mAttractionName = attractionName;
        mAttractionDescription = attractionDescription;
        hasDescription = true;
        mImageResourceId = imageResourceId;
        mLatitude = latitude;
        mLongitude = longitude;
        mMapButton = mapButton;
    }

    /**
     * Create a new Item object.
     *
     * @param attractionName is the string resource ID for the item name
     * @param latitude       is the resource ID for the latitude of the item
     * @param longitude      is the resource ID for the longitude of the item
     * @param mapButton      is the drawable resource ID for the icon associated with the item
     */
    public Item(String attractionName, int imageResourceId,
                double latitude, double longitude, int mapButton) {
        mAttractionName = attractionName;
        mImageResourceId = imageResourceId;
        mLatitude = latitude;
        mLongitude = longitude;
        mMapButton = mapButton;
    }

    /**
     * Create a new Item object.
     *
     * @param attractionName is the string resource ID for the item name
     * @param latitude       is the resource ID for the latitude of the item
     * @param longitude      is the resource ID for the longitude of the item
     * @param mapButton      is the drawable resource ID for the icon associated with the item
     */
    public Item(String attractionName,
                double latitude, double longitude, int mapButton) {
        mAttractionName = attractionName;
        mLatitude = latitude;
        mLongitude = longitude;
        mMapButton = mapButton;
    }

    /**
     * Get the string resource ID for the Item name
     */
    public String getAttractionName() {
        return mAttractionName;
    }

    /**
     * Get the string resource ID for the Item description
     */
    public String getAttractionDescription() {
        return mAttractionDescription;
    }

    /**
     * Return the image resource ID of the Item
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Returns the latitude of the Item
     */
    public double getLatitude() {
        return mLatitude;
    }

    /**
     * Returns the longitude of the Item
     */
    public double getLongitude() {
        return mLongitude;
    }

    /**
     * Return the icon resource ID of the Item
     */
    public int getMapButton() {
        return mMapButton;
    }

    /**
     * check if the item has description
     */
    public boolean hasDescription() {
        return hasDescription;
    }
}
