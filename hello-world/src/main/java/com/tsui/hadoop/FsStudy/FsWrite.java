package com.tsui.hadoop.FsStudy;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

/**
 * 写入数据
 * 
 * @author xmtsui
 * @version v1.0
 */
class FsWrite {
	static {
	}

	public static void main(String[] agrs) {
		try {
			InputStream in;
			in = new BufferedInputStream(new FileInputStream(
					"/Users/saixiaomin/Desktop/result.txt"));

			URI uri;
			uri = new URI("hdfs://localhost:9000/user/xmtsui/HelloTxt.txt");
			
			Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(uri, conf);
			
			/*一次性新建所有必要但还没有的父目录，
			 * 所有新建成功后返回true.
			 * 通常不需要用这个，
			 * 因为调用create写入文件时会自动创建父目录
			 * */
			//fs.mkdirs(path);
			
			OutputStream out = null;
			
			/*类似FSDataInputStream，可有getPos()，
			 * 但hdfs不允许在除了文件末尾外的其他地方写入，
			 * 只允许顺序写入，
			 * 因此写入时定位意义不大*/
			FSDataOutputStream fsout = null;
			out = fsout = fs.create(new Path(uri), new Progressable() {
				public void progress() {
					System.out.println(".");
				}
			});
			System.out.println("pos: " + fsout.getPos());
			IOUtils.copyBytes(in, out, 4096, true);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}