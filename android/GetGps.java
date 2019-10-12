
class  GetGps{	
	//获取GPS位置，不依赖第三方地图SDK
	private static String provider;
    private  Location lastLocation;

    private void getLocation() {
        //        获取当前位置信息
        //获取定位服务
        LocationManager locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {
            Log.i("map","用户不同意使用GPS");
            return ;
        }
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        lastLocation=bestLocation;
        if(lastLocation!=null)
            Log.i("map","last location get success!,"+lastLocation.getLatitude()+","+lastLocation.getLongitude());
        else
            Log.i("map","未知原因，获取map失效");

    }
    public  void getMyLocation() {

        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PERMISSION_GRANTED){//未开启定位权限
            //开启定位权限,200是标识码
            Log.i("map","请求GPS权限");
            ActivityCompat.requestPermissions(TxtContentActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},200);
        }else{
            Log.i("map","获取GPS权限成功");
            getLocation();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 200://刚才的识别码
                if(grantResults[0] == PERMISSION_GRANTED){//用户同意权限,执行我们的操作
                   getLocation();//开始定位
                }else{//用户拒绝之后,当然我们也可以弹出一个窗口,直接跳转到系统设置页面
                    Toast.makeText(TxtContentActivity.this,"未开启定位权限,请手动到设置去开启权限",Toast.LENGTH_LONG).show();
                }
                break;
            default:break;
        }
    }
}	
```