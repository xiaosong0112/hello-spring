package geektime.spring.demo.hellospring.flink;


import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class Flink01APP {

    public static void main(String[] args) throws Exception {

        // 构建执行任务环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //设置并行度
        env.setParallelism(4);

        //相同类型元素的数据流 source
        DataStream<String> stringDS = env.fromElements("java,SpringBoot", "spring cloud,redis", "kafka,小滴课堂");
        stringDS.print("处理前");

        DataStream<String> flatMapDs = stringDS.flatMap(new FlatMapFunction<String, String>() {

            @Override
            public void flatMap(String s, Collector<String> collector) throws Exception {
                String[] arr = s.split(",");
                for (int i = 0; i < arr.length; i++) {
                    collector.collect(arr[i]);
                }
            }
        });

        flatMapDs.print("处理后");
        env.execute("flatmap job");
    }
}
