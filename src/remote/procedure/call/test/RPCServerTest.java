package remote.procedure.call.test;
import remote.procedure.call.server.HelloService;
import remote.procedure.call.server.HelloServiceImpl;
import remote.procedure.call.server.Server;
import remote.procedure.call.server.ServerCenter;
public class RPCServerTest {
	public static void main(String[] args) {
		//开启一个线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				//服务中心
				Server server = new ServerCenter(9999);
				//将HelloService接口及实现类 注册到 服务中心
				server.register(HelloService.class, HelloServiceImpl.class);
				server.start(); 
			}
		}).start();//start()
	}
}
