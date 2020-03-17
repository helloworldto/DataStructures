package datacode;
/*
 * temp.next的含义
 * 以及temp的含义
 * 
 */



public class SingleLinkList {

	//定义HeroNode,每个HeroNode对象就是一个节点
	static class HeroNode{
		public int no;
		public String name;
		public String nickname;
		public HeroNode next; //指向下一个节点
		
		//构造器
		public HeroNode(int no,String name,String nickname) {
			this.no = no;
			this.name = name;
			this.nickname = nickname;

		}
		
		@Override
		public String toString() {
			return "HeroNode [no=" + no +",name="+ name +",nickname="+ nickname+"]";
		}
		
		
	}	
	
	
	//定义SingleLinkLiset管理我们的英雄
	static class SingleLikList{
		//先初始化一个头节点，头节点不动，不存放具体的数据
		private HeroNode head = new HeroNode(0,"","");
		//添加节点到单向链表
		/*
		 * 当不考虑编号顺序时
		 * 1.找到当前链表的最后节点
		 * 2.将最后这个节点的next指向新的节点
		 */
		public void add(HeroNode heroNode) {
			//因为头不能动，所以需要辅助遍历temp
			HeroNode temp = head;
			while(true) {
				if(temp.next == null) {
					//说明找到了链表的最后
					break;
				}
				temp = temp.next;
			}
			//当退出循环的时候，temp只可能在链表的最后
			//将这个节点的next指向新的节点
			temp.next = heroNode;
		}
		
		
		//显示链表（遍历）
		public void list() {

			//判断链表是否为空
			if(head.next == null) {
				System.out.println("链表为空");
				return;
			}
			//因为头节点不能动同上需要temp
			HeroNode temp = head.next;
			while(true) {
				if(temp == null) {
					break;
				}
				System.out.println(temp);
				temp = temp.next;
			}
			//当退出循环的时候，temp只可能在链表的最后
			//将这个节点的next指向新的节点
	 
		}
		
		

	
	
		

	}
		


	
	public static void main(String[] args) {
		//进行测试
		HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
		HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
		HeroNode hero3 = new HeroNode(3,"吴用","智多星");
		HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

		//创建链表
		SingleLikList singlelinklist = new SingleLikList();
		singlelinklist.add(hero1);
		singlelinklist.add(hero2);
		singlelinklist.add(hero4);
		singlelinklist.add(hero3);

		singlelinklist.list();



	}



}
