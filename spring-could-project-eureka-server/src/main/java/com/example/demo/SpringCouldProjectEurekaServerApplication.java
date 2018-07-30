package com.example.demo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  // 启动一个服务注册中心提供给其他应用进行注册
public class SpringCouldProjectEurekaServerApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SpringCouldProjectEurekaServerApplication.class, args);
//		Thread t1 = new Thread(new MyThread(null),"t1") ;
//		Thread t2 = new Thread(new MyThread(t1),"t2") ;
//		Thread t3 = new Thread(new MyThread(t2),"t3") ;
//		t3.start();
//		t2.start();
//		t1.start();
	}
	
	static class MyThread implements Runnable{
		Thread next ;
		public MyThread(Thread next) {
			this.next = next ;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(new Random().nextInt(1000));
				if(next != null) next.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
		
	}
}
