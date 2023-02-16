interface MediaPlayer{
    public void play(String type, String fileName);
}

class BasicMediaPlayer implements MediaPlayer{
   public void play(String type, String fileName){
      if (type.equalsIgnoreCase("vlc")){
         System.out.println("Playing mp3 file. Name: "+ fileName);

      }
      else{
            System.out.println("Invalid media. " + type + " format not supported");
      }
   }
}

class AdvancedMediaPlayer{
   public void playVlc(String fileName){
      System.out.println("Playing vlc file. Name: "+ fileName);
   }
   public void playMp4(String fileName){
      System.out.println("Playing mp4 file. Name: "+ fileName);
   }
}
