package test;

import java.io.File;

import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.VideoAttributes;
import ws.schild.jave.VideoInfo;
import ws.schild.jave.VideoSize;

public class Mp4 {
	public static void main(String[] args) {
		File source = new File("D:\\test\\mi.mp4");
		File target = new File("D:\\test\\avimi.avi");
		try {
			if (target.exists()) {
				target.delete();
			}

			long startTime = System.currentTimeMillis(); // 获取开始时间

			AudioAttributes audio = new AudioAttributes();  
			audio.setCodec("libmp3lame");  
			audio.setBitRate(new Integer(56000));  
			audio.setChannels(new Integer(1));  
			audio.setSamplingRate(new Integer(22050));  
			VideoAttributes video = new VideoAttributes();  
			video.setCodec(VideoAttributes.DIRECT_STREAM_COPY);  
			EncodingAttributes attrs = new EncodingAttributes();  
			attrs.setFormat("avi");  
			attrs.setAudioAttributes(audio);  
			attrs.setVideoAttributes(video);  
			Encoder encoder = new Encoder();
			MultimediaObject multimediaObject = new MultimediaObject(source);
			encoder.encode(multimediaObject, target, attrs);// 转换开始。。。

			MultimediaInfo info1 = multimediaObject.getInfo();
			VideoInfo video1 = info1.getVideo();
			String decoder1 = video1.getDecoder();
			System.out.println(decoder1);

			long endTime = System.currentTimeMillis(); // 获取结束时间

			System.out.println("程序运行时间：" + (endTime - startTime)/1000 + "秒"); // 输出程序运行时间
		} catch (EncoderException e) {
			e.printStackTrace();
		}
	}
}
