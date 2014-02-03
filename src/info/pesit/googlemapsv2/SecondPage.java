package info.pesit.googlemapsv2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;





public class SecondPage extends FragmentActivity {

	// Google Map
		private GoogleMap googleMap;
		double latitude = 12.9338;
		double longitude = 77.5345;
		double myLat,myLon;
		//pesit coordinates 12.935261,77.536556
		//first bus coordinates 12.931685,77.542039
		//second bus coordinates 12.929217,77.54486
		// third bus coordinates 12.926258,77.54853
		Handler h =new Handler();
		
		double lat1=12.935261;
		double lon1=77.536556;
		double lat2=12.931685;
		double lon2=77.542039;
		double dlon=Math.toRadians(lon2-lon1);
		double dlat=Math.toRadians(lat2-lat1);
		double a=Math.sin(dlat/2)*Math.sin(dlat/2)+Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))*Math.sin(dlon/2)*Math.sin(dlon/2);
		double c=2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
		double d=6371*c;
		
		//NotificationManager notificationmanager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		
		
		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			
			/*NotificationCompat.Builder mBuilder =new NotificationCompat.Builder(this)
	        .setSmallIcon(R.drawable.ic_action_map)
	        .setContentTitle("My notification")
	        .setContentText("Hello World!");
			
			*/
			
			
			
			
			h.postDelayed(r, 10000);
			
			
			LocationManager lm= (LocationManager)getSystemService(this.LOCATION_SERVICE);
			LocationListener listener = new LocationListener()
			{

				@Override
				public void onLocationChanged(Location location) 
				{
					// TODO Auto-generated method stub
					doWithGPS(location.getLatitude(),location.getLongitude());
					myLat=location.getLatitude();
					myLon=location.getLongitude();
					//Toast.makeText(getBaseContext(), "My Lat is "+myLat+"myLon is "+myLon, Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onProviderDisabled(String provider)
				{
					// TODO Auto-generated method stub
					Toast.makeText(getBaseContext(), "GPS not enabled", Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onProviderEnabled(String provider) 
				{
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onStatusChanged(String provider, int status,
						Bundle extras)
				{
					// TODO Auto-generated method stub
					
				}
				
			};
			Location temp =lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			Toast.makeText(getBaseContext(), "Last known : "+temp.getLatitude()+","+temp.getLongitude(), Toast.LENGTH_LONG).show();
			if((System.currentTimeMillis()-temp.getTime())>(2*60*1000))
			{
				Toast.makeText(getBaseContext(), "iN If PART", Toast.LENGTH_LONG).show();
				
				lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 20*1000, 5, listener);
			}
				else
			{
				Toast.makeText(getBaseContext(), "iN ELSE PART", Toast.LENGTH_LONG).show();
				doWithGPS(temp.getLatitude(),temp.getLongitude());
			}
			
			
			try 
			{
				/*
				Toast.makeText(getBaseContext(), "chelsea sucks?", Toast.LENGTH_SHORT);
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				//Create the HTTP request
				HttpParams httpParameters = new BasicHttpParams();

				//Setup timeouts
				HttpConnectionParams.setConnectionTimeout(httpParameters, 15000);
				HttpConnectionParams.setSoTimeout(httpParameters, 15000);
				Toast.makeText(getBaseContext(), "Did we get some shit herebfadsjb?", Toast.LENGTH_SHORT);

				HttpClient httpclient = new DefaultHttpClient(httpParameters);
				HttpPost httppost = new HttpPost("http://impressit.net84.net/get_stuff.php");
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				
				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();

				String result = EntityUtils.toString(entity);
				Toast.makeText(getBaseContext(), "Did we get some shit here?", Toast.LENGTH_SHORT);
				
				
				
				// Create a JSON object from the request response
				JSONObject jsonObject = new JSONObject(result);

				//Retrieve the data from the JSON object
				String latitude1 =  jsonObject.getString("latitude");
				String longitude1 = jsonObject.getString("longitude");
				Toast.makeText(getBaseContext(), "Latitude1="+latitude+"longitude1="+longitude, Toast.LENGTH_SHORT).show();
				/*try 
				{
					
					Toast.makeText(getBaseContext(), "chelsea sucks?", Toast.LENGTH_SHORT);
					ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					//Create the HTTP request
					HttpParams httpParameters = new BasicHttpParams();

					//Setup timeouts
					HttpConnectionParams.setConnectionTimeout(httpParameters, 15000);
					HttpConnectionParams.setSoTimeout(httpParameters, 15000);
					Toast.makeText(getBaseContext(), "Did we get some shit herebfadsjb?", Toast.LENGTH_SHORT);

					HttpClient httpclient = new DefaultHttpClient(httpParameters);
					HttpPost httppost = new HttpPost("http://impressit.net84.net/get_stuff.php");
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					
					HttpResponse response = httpclient.execute(httppost);
					HttpEntity entity = response.getEntity();

					String result = EntityUtils.toString(entity);
					Toast.makeText(getBaseContext(), "Did we get some shit here?", Toast.LENGTH_SHORT);
					
					
					
					// Create a JSON object from the request response
					JSONObject jsonObject = new JSONObject(result);

					//Retrieve the data from the JSON object
					latitude = (Double) jsonObject.get("latitude");
					longitude = (Double)jsonObject.get("longitude");
					Toast.makeText(getBaseContext(), "Latitude="+latitude+"longitude="+longitude, Toast.LENGTH_SHORT).show();
				}
				catch(Exception e)
				{
					Toast.makeText(getBaseContext(), "Yo man! we've got some shit here", Toast.LENGTH_SHORT).show();
					e.printStackTrace();
				}
				
				*/
				
				
				
				
				
				// Loading map
				initilizeMap();
				//Toast.makeText(getBaseContext(), "My lat is "+myLat+ "My lon is "+myLon, Toast.LENGTH_SHORT).show();

		
					// Changing map type
				googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
				// googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
				// googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
				// googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
				// googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

				// Showing / hiding your current location
				googleMap.setMyLocationEnabled(true);

				// Enable / Disable zooming controls
				googleMap.getUiSettings().setZoomControlsEnabled(false);

				// Enable / Disable my location button
				googleMap.getUiSettings().setMyLocationButtonEnabled(true);

				// Enable / Disable Compass icon
				googleMap.getUiSettings().setCompassEnabled(true);

				// Enable / Disable Rotate gesture
				googleMap.getUiSettings().setRotateGesturesEnabled(true);

				// Enable / Disable zooming functionality
				googleMap.getUiSettings().setZoomGesturesEnabled(true);

				
				// lets place some 10 random markers
				/*	for (int i = 0; i < 10; i++) {
					// random latitude and logitude
					double[] randomLocation = createRandLocation(latitude,
							longitude);
				 */
				//12.922106, 77.560019
				
				
				
				
			
				
				
				int j=-2;
				for(int i=0; i<4; i++)
				{
					double[] randomLocation = {12.935261,77.536556,12.931685,77.542039,12.929217,77.54486,12.926258,77.54853};
					// Adding a marker
					j = j+2;
					
					MarkerOptions marker = new MarkerOptions().position(
							new LatLng(randomLocation[j], randomLocation[j+1]))
							.title("Hello Maps " + i);

					Log.e("Random", "> " + randomLocation[0] + ", "
							+ randomLocation[1]);

					// changing marker color
					if (i == 0)
						marker.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
					if (i == 1)
						marker.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
					if (i == 2)
						marker.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
					if (i == 3)
						marker.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
					if (i == 4)
						marker.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
					if (i == 5)
						marker.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
					if (i == 6)
						marker.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_RED));
					if (i == 7)
						marker.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
					if (i == 8)
						marker.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
					if (i == 9)
						marker.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

					googleMap.addMarker(marker);
					
					
					//LatLngBounds.Builder builder = new LatLngBounds.Builder();
					
					//for (Marker m : markers) {
					//    builder.include(m.getPosition());
					//}
					//LatLngBounds bounds = builder.build();
					// Move the camera to last position with a zoom level
					//int padding = 0; // offset from edges of the map in pixels
					//CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
					
					//googleMap.animateCamera(cu);
					if (i == 2)
					{
						CameraPosition cameraPosition = new CameraPosition.Builder()
								.target(new LatLng(randomLocation[0],
										randomLocation[1])).zoom(15).build();

						googleMap.animateCamera(CameraUpdateFactory
								.newCameraPosition(cameraPosition));
					
					}
				
				}
			} 
			catch (Exception e)
			{
				Toast.makeText(getBaseContext(), "Anything here", Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}

		}
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu)
	    {
	        MenuInflater menuInflater = getMenuInflater();
	        menuInflater.inflate(R.menu.main, menu);
	        return true;
	    }
		
		

		@Override
		protected void onResume()
		{
			super.onResume();
			initilizeMap();
		}

		/**
		 * function to load map If map is not created it will create it for you
		 * */
				
		
		
		private void initilizeMap()
		{
			if (googleMap == null)
			{
				googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(
						R.id.map)).getMap();

				// check if map is created successfully or not
				if (googleMap == null)
				{
					Toast.makeText(getApplicationContext(),
							"Sorry! unable to create maps", Toast.LENGTH_SHORT)
							.show();
				}
			}
		}
		
		
				
				
		void doWithGPS(double meralat,double meralon)
		{
			//Toast.makeText(getBaseContext(), "MyLat is "+meralat+"MyLon is "+meralon, Toast.LENGTH_SHORT).show();
			Log.d("Message", "lat is "+meralat+"lon is "+meralon);
			Toast.makeText(getBaseContext(), "Latitude:"+meralat + " Longitude: "+meralon,Toast.LENGTH_LONG).show();
		}
		/*
		 * creating random postion around a location for testing purpose only
		 */
		
		/*private double[] createRandLocation(double latitude, double longitude) {

			return new double[] { latitude + ((Math.random() - 0.5) / 500),
					longitude + ((Math.random() - 0.5) / 500),
					150 + ((Math.random() - 0.5) * 10) };
		}*/
		
		private Runnable r=new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(d<1)
				{
					AlertDialog.Builder builder = new AlertDialog.Builder(SecondPage.this);
			        builder.setTitle("Bulk Productions")
			        .setMessage("Distance between 2 points is "+d)
			        .setCancelable(false)
			        .setNegativeButton("Close",new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int id) {
			                dialog.cancel();
			            }
			        });
			        AlertDialog alert = builder.create();
			        alert.show();
			        Vibrator vibrator;
			        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			        vibrator.vibrate(500);
				}
				
				
			
				
				
				
			}
			
		};
			
	
}
