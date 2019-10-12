//写入到/data/data/packageName/中，外部无法读出
    private void writeFileData(String filename,String message) {
        FileOutputStream fileOutputStream ;
        Log.i("info","写入文件的路径为:"+filename);

        try {
            fileOutputStream = context.openFileOutput(filename, context.MODE_APPEND);
            byte[] bytes = message.getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String readFileData(String filename){
        String result="";
        try{
            FileInputStream fileInputStream = context.openFileInput(filename);
            int length = fileInputStream.available();
            byte[] bytes = new byte[length];
            fileInputStream.read(bytes);
            result=new String(bytes);
            fileInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }