package com.sift;
import static java.lang.System.*;

import java.io.IOException;
import java.util.*;

import com.brief.gray;

public class screening {
	
	
	public static double Screen(List<Match> ms,String f1,String f2) {
		
		List<Point> points=new ArrayList<Point>();
		int index=0;
		KDFeaturePoint p1 =new KDFeaturePoint();
		KDFeaturePoint p2 = new KDFeaturePoint();
		Entry[] dist=new Entry[ms.size()];
		double distance=0;
		for(int i=0;i<ms.size();i++) {
			Point point = new Point();
			Point MapPoint=new Point();
			 dist[i]=new Entry();
			 p1 = ms.get(i).fp1;
			 p2 = ms.get(i).fp2;	
			 distance=Math.sqrt(p1.x*p1.x+p1.y*p1.y);
			 
			 dist[i].dist=distance;
			 dist[i].setX(p1.x);
			 dist[i].setY(p1.y);;
			 MapPoint.setX(p2.x);
			 MapPoint.setY(p2.y);
			 dist[i].setMap(MapPoint);
			 
		}
		index=0;
		for(int i=0;i<dist.length;i++) {
			for(int j=i+1;j<dist.length;j++) {
				if(dist[i].dist>dist[j].dist) {
					Entry temp=dist[i];
					dist[i]=dist[j];
					dist[j]=temp;
				}	
			}
			
		}
		
		
		for(int i=0;i<dist.length;i++) {
			Point point = new Point();
			Point MapPoint=new Point();
			Point next=new Point();
			Point prior=new Point();
			if(i==0) {
				next.setX(dist[i+1].getX());
				next.setY(dist[i+1].getY());
				dist[i].setNext(dist[i+1]);
				prior.setX(dist[i+2].getX());
				prior.setY(dist[i+2].getY());
				dist[i].setPrior(dist[i+2]);
				MapPoint=dist[i+1].getMap();
				next.x=MapPoint.x;
				next.y=MapPoint.y;
				dist[i].getMap().setNext(next);
				MapPoint=dist[i+2].getMap();
				prior.x=MapPoint.x;
				prior.y=MapPoint.y;
				dist[i].getMap().setPrior(prior);
			}else if(i==dist.length-1) {
				next.x=dist[i-1].x;
				next.y=dist[i-1].y;
				dist[i].setNext(dist[i-1]);
				prior.x=dist[i-2].x;
				prior.y=dist[i-2].y;
				dist[i].setPrior(dist[i-2]);
				MapPoint=dist[i-1].getMap();
				next.x=MapPoint.x;
				next.y=MapPoint.y;
				dist[i].Map.setNext(next);
				MapPoint=dist[i-2].getMap();
				prior.x=MapPoint.x;
				prior.y=MapPoint.y;
				dist[i].Map.setPrior(prior);
			}else {
				next.x=dist[i+1].x;
				next.y=dist[i+1].y;
				dist[i].setNext(dist[i+1]);
				prior.x=dist[i-1].x;
				prior.y=dist[i-1].y;
				dist[i].setPrior(dist[i-1]);
				MapPoint=dist[i+1].getMap();
				next.x=MapPoint.x;
				next.y=MapPoint.y;
				dist[i].Map.setNext(next);
				MapPoint=dist[i-1].getMap();
				prior.x=MapPoint.x;
				prior.y=MapPoint.y;
				
				dist[i].Map.setPrior(prior);
			}
			//System.out.println(dist[i].x+" : "+dist[i].next.x+"    "+dist[i].y+"  :  "+dist[i].next.y);
			//System.out.println(dist[i].getMap().x+" : "+dist[i].getMap().next.x+"    "+dist[i].getMap().y+"  :  "+dist[i].getMap().next.y);
			dist[i].nextVal=Math.sqrt((dist[i].x-dist[i].next.x)*(dist[i].x-dist[i].next.x)
					+(dist[i].y-dist[i].next.y)*(dist[i].y-dist[i].next.y));
			dist[i].priorVal=Math.sqrt((dist[i].x-dist[i].prior.x)*(dist[i].x-dist[i].prior.x)
					+(dist[i].y-dist[i].prior.y)*(dist[i].y-dist[i].prior.y));
			dist[i].Map.nextVal=Math.sqrt((dist[i].Map.x-dist[i].Map.next.x)*(dist[i].Map.x-dist[i].Map.next.x)
					+(dist[i].Map.y-dist[i].Map.next.y)*(dist[i].Map.y-dist[i].Map.next.y));
			dist[i].Map.priorVal=Math.sqrt((dist[i].Map.x-dist[i].Map.prior.x)*(dist[i].Map.x-dist[i].Map.prior.x)
					+(dist[i].Map.y-dist[i].Map.prior.y)*(dist[i].Map.y-dist[i].Map.prior.y));
			//System.out.println("distNext : "+dist[i].nextVal+" distPrior : "+dist[i].priorVal);
		}
		
		double sum=0;
		int tongji=0;
		double[] absdist=new double[dist.length];
		
		for(int i=0;i<dist.length;i++) {	
			
			double dist1=Math.abs(dist[i].nextVal-dist[i].Map.nextVal);
			double dist2=Math.abs(dist[i].priorVal-dist[i].Map.priorVal);
			double point1=Math.sqrt((dist[i].getX()*dist[i].getX())+(dist[i].getY()*dist[i].getY()));
			double point2=Math.sqrt((dist[i].getMap().getX()*dist[i].getMap().getX())
					+(dist[i].getMap().getY()*dist[i].getMap().getY()));
			double dist3=Math.abs(point1-point2);
			absdist[i]=dist3;
			//System.out.println("dist1 : "+dist1+" dist2 : "+dist2);
			dist[i].distance=Math.abs(dist1-dist2);
			/*System.out.println(" 原点 Pos( "+dist[i].getX()+
					" , "+dist[i].getY()+" ) "+" 对应点 Pos( "+dist[i].getMap().getX()+
					" , "+dist[i].getMap().getY()+" ) "+"差值 ："+dist3);
			System.out.println();*/
			sum+=dist[i].distance;
		}
		for(int i=0;i<absdist.length;i++) {
			for(int j=i+1;j<absdist.length;j++) {
				if(absdist[i]>absdist[j]) {
					double temp;
					temp=absdist[i];
					absdist[i]=absdist[j];
					absdist[j]=temp;
				}
			}
			
		}
		/*for(int i=0;i<absdist.length;i++) {
			System.out.println("差值 : "+absdist[i]);
		}*/
		System.out.println();
		double[] end=new double[absdist.length-1];
		for(int i=1;i<absdist.length;i++) {
			end[i-1]=Math.abs(absdist[i]-absdist[i-1]);
		
		}
		for(int i=0;i<end.length;i++) {
			for(int j=i+1;j<end.length;j++) {
				if(end[i]>end[j]) {
					double temp;
					temp=end[i];
					end[i]=end[j];
					end[j]=temp;
				}
			}
			
		}
		int number_result=0;
		for(int i=0;i<absdist.length-1;i++) {
			if(end[i]<0.6) {
				number_result++;
			}
			//System.out.println("结果差值 : "+(end[i]));
		}
		System.out.println("预测值："+number_result+"  占比 :  "+((double)number_result/end.length));
		
		return ((double)number_result/end.length);
		
	}
	
	public static Entry[] Sort(List<Match> ms ) {
		List<Point> points=new ArrayList<Point>();
		int index=0;
		KDFeaturePoint p1 =new KDFeaturePoint();
		KDFeaturePoint p2 = new KDFeaturePoint();
		Entry[] dist=new Entry[ms.size()];
		double distance=0;
		for(int i=0;i<ms.size();i++) {
			Point point = new Point();
			Point MapPoint=new Point();
			 dist[i]=new Entry();
			 p1 = ms.get(i).fp1;
			 p2 = ms.get(i).fp2;	
			 distance=Math.sqrt(p1.x*p1.x+p1.y*p1.y);
			 
			 dist[i].dist=distance;
			 dist[i].setX(p1.x);
			 dist[i].setY(p1.y);;
			 MapPoint.setX(p2.x);
			 MapPoint.setY(p2.y);
			 dist[i].setMap(MapPoint);
			 
		}
		index=0;
		for(int i=0;i<dist.length;i++) {
			for(int j=i+1;j<dist.length;j++) {
				if(dist[i].dist>dist[j].dist) {
					Entry temp=dist[i];
					dist[i]=dist[j];
					dist[j]=temp;
				}	
			}
			
		}
		
		return dist;
	}
	

}
