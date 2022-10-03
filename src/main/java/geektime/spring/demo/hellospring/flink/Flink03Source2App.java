package geektime.spring.demo.hellospring.flink;

import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Flink03Source2App {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //设置运行模式为流批一体
        env.setRuntimeMode(RuntimeExecutionMode.AUTOMATIC);
        env.setParallelism(1);
        DataStream<String> textDs = env.readTextFile("/Users/wangjialin/Desktop/text1.txt");
        textDs.print("text1内容");
        //  nc -l -p 8888 开启端口监听  macbook   nc -lk 8888  linux
        DataStream<String> socketDs = env.socketTextStream("127.0.0.1", 8888);
        socketDs.print("监听8888端口输入内容");
        env.execute("source2 job");
    }
}
