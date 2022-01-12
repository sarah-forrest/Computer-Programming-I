// This program stores the coordinates of White's stash, FBI building, and ABQ studios as
// geolocation objects and prints the latitude/longitude of each and the distance in miles 
// between the stash/studio and the stash/FBI

public class GeoLocationClient {
   public static void main(String[] args) {
      GeoLocation stash = new GeoLocation(34.988889, -106.614444);
		GeoLocation abqStudio = new GeoLocation(34.989978, -106.614357);
		GeoLocation fbiBuilding = new GeoLocation(35.131281, -106.61263);
		System.out.println("the stash is at " + stash.toString());
		System.out.println("ABQ studio is at " + abqStudio.toString());
		System.out.println("FBI building is at " + fbiBuilding.toString());
		System.out.println("distance in miles between:");
		System.out.println("    stash/studio = " + stash.distanceFrom(abqStudio));
		System.out.println("    stash/fbi    = " + stash.distanceFrom(fbiBuilding));
	}
}