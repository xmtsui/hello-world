package com.tsui.hadoop.FsStudy;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

/**
 * 从URL中读取数据
 * 
 * @author xmtsui
 * @version v1.0
 */
class FsReadFromURL {
	static {
		//java.net.URL.setURLStreamHandlerFactory该方法在虚拟机启动后只能调用一次
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}

	public static void main(String[] agrs) {
		InputStream in = null;
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
		try {
			//指定core-site中配置的端口号，默认8020，namenode RPC交互端口
			in = new URL("hdfs://localhost:9000/user/xmtsui/Product.java")
					.openStream();
			IOUtils.copyBytes(in, System.out, 1024, false);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeStream(in);
		}
	}
}