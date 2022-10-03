package geektime.spring.demo.hellospring.flink;


import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

import java.util.Arrays;

public class Flink03Source1APP {

    public static void main(String[] args) throws Exception {

        // 构建执行任务环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setRuntimeMode(RuntimeExecutionMode.AUTOMATIC);
        //设置并行度
        env.setParallelism(1);

        //相同类型元素的数据流 source
        DataStream<String> stringDS1 = env.fromElements("java,SpringBoot", "spring cloud,redis", "kafka,小滴课堂");
        stringDS1.print("ds1");

        DataStream<String> stringDS2 = env.fromCollection(Arrays.asList("java,SpringBoot", "spring cloud,redis", "kafka,小滴课堂"));
        stringDS2.print("ds2");

        DataStream<Long> longDS3 = env.fromSequence(0, 10);
        longDS3.print("ds3");
        env.execute("source job");
    }
}
