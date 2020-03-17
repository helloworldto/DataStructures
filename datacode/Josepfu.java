package datacode;

public class Josepfu {
	
	static class Boy{
		private int no; //编号
		private Boy next;
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public Boy getNext() {
			return next;
		}
		public void setNext(Boy next) {
			this.next = next;
		}
		public Boy(int no) {
			this.no = no;
		}


	
	}
	
	//创建环形单向链表
	static class CicleSingleLinkList{
		//创建一个first节点，当前没有编号
		private Boy first = new Boy(-1);
		//添加小孩节点，构建成一个环形的链表
		public void addBoy(int nums) {
			//nums 需要进行检验
			if(nums < 2) {
				System.out.println("nums的值不正确");
				return;
			}
			Boy curBoy = null; //辅助节点
			//使用for循环创建环形链表
			for(int i = 1; i <= nums;i++) {
				Boy boy = new Boy(i);
				if(i == 1) {
					first = boy;
					curBoy = first; //curBoy指向第一个小孩
				}else {
					 curBoy.setNext(boy);
					 boy.setNext(first);
					 curBoy = boy;
				}
			}
		}
		
		//遍历环形链表
		public void list() {
			//链表是否为空
			if(first == null) {
				System.out.println("链表为空");
				return;
			}
			Boy curBoy = first;
			while(true) {
				System.out.printf("Boy的编号%d\n",curBoy.no);
				if(curBoy.getNext() == first) {
					System.out.println("已经遍历结束\n");
					break;
				}
				curBoy = curBoy.getNext();
			}
		}
		
		//删除
		/*
		 * 先将first 和 helper移动k-1次
		 */
		public void delete(int startNo,int countNum,int nums) {
			//从哪个小孩开始数  数几下 最初有几个小孩
			if(first == null||startNo < 1|| startNo > nums) {
				System.out.println("参数有误，请重新输入");
				return;
				}
			Boy helper = first;
			while(true) {
				if(helper.next == first)
					break;
				helper = helper.getNext();
			
			}
			//开始位置
			for(int i = 0; i < startNo -1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			
			//循环出圈操作
			while(true) {
				if(helper.no == first.no)
					break;
				//让first和helper同时移动很多次
				for(int i =0; i < countNum-1;i++) {
					first = first.getNext();
					helper = helper.getNext();
				}
				//此时first所在位置要出圈
				System.out.printf("要出圈的小孩是%d\n",first.getNo());
				first = first.next;
				helper.next = first;
				//helper.setNext(first);
			}
			System.out.printf("最后一位是%d",helper.getNo());
			
			
		}
	}	
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CicleSingleLinkList circlesinglelinklist = new CicleSingleLinkList();
		circlesinglelinklist.addBoy(5);
		circlesinglelinklist.list();
		//没有考虑到一种情况  为空,即在函数中最后一个参数没有用到，除判断外
		circlesinglelinklist.delete(1, 2, 5);
	}

}
