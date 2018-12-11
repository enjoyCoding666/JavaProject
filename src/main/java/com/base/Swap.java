package com.base;

public class Swap {
        public static void main(String[] args) {
            int x = 5;
            int y = 10;
            swap(x,y);
            System.out.println("使用swap1()交换：");
            System.out.println(x);
            System.out.println(y);

            Value v = new Value(5,10);
            swap(v);
            System.out.println("使用swap()2交换：");
            System.out.println(v.getX());
            System.out.println(v.getY());
        }

        // 无效的交换：形参的改变无法反作用于实参
        public static void swap(int x,int y) {
            int temp = x;
            x = y;
            y = temp;
        }

        // 有效的交换：通过引用（变量指向一个对象）来修改成员变量
        public static void swap(Value value) {
            int temp = value.getX();
            value.setX(value.getY() );
            value.setY(temp);
        }
    }

    class Value{
       private int x;
       private int y;

        public Value(int x,int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

