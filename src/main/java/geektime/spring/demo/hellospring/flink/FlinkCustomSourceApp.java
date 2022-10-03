package geektime.spring.demo.hellospring.flink;

import geektime.spring.demo.hellospring.flink.source.VideoOrderSource;
import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkCustomSourceApp {

    public static void main(String[] args) {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        env.setRuntimeMode(RuntimeExecutionMode.AUTOMATIC);
        DataStream videoOrderDs = env.addSource(new VideoOrderSource());
        videoOrderDs.print("打印生成的订单");
    }

}
