package geektime.spring.demo.hellospring.flink.source;

import geektime.spring.demo.hellospring.flink.model.VideoOrder;
import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

import java.util.*;

/**
 * 自定义订单数据源
 */
public class VideoOrderSource extends RichParallelSourceFunction<VideoOrder> {

    private Boolean flag = true;

    private Random random = new Random();

    private static List<String> list = new ArrayList();

    static {

        list.add("spring boot2.x课程");
        list.add("微服务SpringCloud");
        list.add("RabbitMQ消息队列");
        list.add("kafka课程");
        list.add("小滴课堂面试专题第一季");
        list.add("Flink流式技术课程");
        list.add("工业级微服务项目大课训练营");
        list.add("Linux课程");
    }

    @Override
    public void run(SourceContext<VideoOrder> sourceContext) throws Exception {

        while(flag) {
            // 一秒产生一个订单
            Thread.sleep(1000);
            String id = UUID.randomUUID().toString();
            int userId = random.nextInt(10);
            int money = random.nextInt(100);
            String title = list.get(random.nextInt(list.size()));
            VideoOrder videoOrder = new VideoOrder();
            videoOrder.setTradeNO(id);
            videoOrder.setTitle(title);
            videoOrder.setMoney(money);
            videoOrder.setUserId(userId);
            videoOrder.setCreateDate(new Date());
            sourceContext.collect(videoOrder);
        }
    }

    @Override
    public void cancel() {

        flag = false;
    }
}
