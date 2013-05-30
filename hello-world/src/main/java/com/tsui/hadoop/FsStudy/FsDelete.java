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
class FsDelete {
	static {
	}

	public static void main(String[] agrs) {
		try {
			URI uri = new URI("hdfs://localhost:9000/user/xmtsui/HelloTxt.txt");
			
			Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(uri, conf);
			
			/*一次性新建所有必要但还没有的父目录，
			 * 所有新建成功后返回true.
			 * 通常不需要用这个，
			 * 因为调用create写入文件时会自动创建父目录
			 * */
			//fs.mkdirs(path);
			
			/*
			 * 删除文件或目录
			 * 当文件或者空目录，r忽略
			 */
			//fs.delete(f, recursive);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}