package test1;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import javax.swing.plaf.SpinnerUI;

/**
 * ѭ��
 */
public class xunhuan {
    public static void main(String[] args) {
      /*  //1��������
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

        //2�������
        //2-1���������ο����ڳ����Ϊ30�����У����俴Ϊ������д
        for (int i = 0; i < 30; i++) {
            //���
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
