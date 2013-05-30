package com.tsui.hadoop.FsStudy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/**
 * 使用Hadoop API读取数据
 * 
 * @author xmtsui
 * @version v1.0
 */
class FsReadFromAPI {
	static {
	}

	public static void main(String[] agrs) {
		Configuration conf = new Configuration();
		
		System.out.println(conf.get("hadoop.tmp.dir"));
		URI uri = URI.create("hdfs://localhost:9000/user/xmtsui/Product.java");
		InputStream in = null;
		
		//继承自DataInputStream实现了Seekable接口,
		//实现了PositionalReadable（会记录初始位置，保留原始偏移量，且线程安全）
		FSDataInputStream fsin = null;
		try {
			FileSystem fs = FileSystem.get(uri, conf);
			in = fsin = fs.open(new Path(uri));
			in.skip(50);//区分seek
			IOUtils.copyBytes(in, System.out, 1024, false);
			fsin.seek(0);//区分skip, seek开销比较大
			IOUtils.copyBytes(in, System.out, 1024, false);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			IOUtils.closeStream(in);
		}
	}
}