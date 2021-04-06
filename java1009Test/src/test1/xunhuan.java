package test1;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import javax.swing.plaf.SpinnerUI;

/**
 * 循环
 */
public class xunhuan {
    public static void main(String[] args) {
      /*  //1、三角形
        for (int i = 0; i < 20; i++) {

            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }

            for (int k = i; k < 20 ; k++) {
                System.out.print(" ");
            }
            for (int k = i; k < 20 ; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i+1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/

        //2、五角星
        //2-1、将三角形看做在长宽各为30矩形中，将其看为三部分写
        for (int i = 0; i < 30; i++) {
            //左边
            for (int j = i; j < 30 ; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
            if(i==20){
                System.out.print(" ");
            }
        }


    }
}
