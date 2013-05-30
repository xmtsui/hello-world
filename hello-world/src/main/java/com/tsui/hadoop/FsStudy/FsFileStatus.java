package com.tsui.hadoop.FsStudy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

/**
 * 文件状态操作
 * 
 * @author xmtsui
 * @version v1.0
 */
class FsFileStatus {
	static {
	}

	public static void main(String[] agrs) {
		try {
			URI uri = new URI("hdfs://localhost:9000/user/xmtsui/");
			URI uri1 = new URI("hdfs://localhost:9000/*");
			
			FileStatus[] f_sta = null; 
			Path[] paths = null;
			
			Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(uri, conf);
			
			f_sta = fs.listStatus(new Path(uri));
			paths = FileUtil.stat2Paths(f_sta);
			for(Path item : paths)//为何能打印path，不能打印FileStatus
			{
				System.out.println(item);
			}
			
			//通配符形式
			f_sta = fs.globStatus(new Path(uri1));
			paths = FileUtil.stat2Paths(f_sta);
			for(Path item : paths)
			{
				System.out.println(item);
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}