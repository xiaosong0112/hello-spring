package geektime.spring.demo.hellospring.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;


public class WebUIApp {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(new Configuration());
        env.setParallelism(1);
        DataStream<String> dataStream = env.socketTextStream("127.0.0.1", 8888);
        // 打印处理前数据
        dataStream.print("参数");
        DataStream<String> flatMapDataStream = dataStream.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String s, Collector<String> collector) throws Exception {
                String[] arr = s.split(",");
                for (String str : arr) {
                    collector.collect(str);
                }
            }
        });
        // 打印处理后数据
        flatMapDataStream.print("结果 ");

        // 最后的execute一定要加，不然不会执行
        env.execute("webui job");
        // socket 端口监听命令 需要安装 brew 通过brew 安装netcat
        // macbook ： nc -l -p 8888
        // linux : nc -lk 8888
    }
}
