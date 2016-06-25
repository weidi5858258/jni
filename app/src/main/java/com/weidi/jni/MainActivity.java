package com.weidi.jni;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv = (TextView) findViewById(R.id.tv);
        tv.setText(JniUtils.getStringFromC("哈哈哈哈"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        test();

    }

    private void test() {
        // 传基本数据类型就这样传
        System.out.println("--------------------->String:" + JniUtils.getStringFromC("王力伟weidi5858258"));
        System.out.println("--------------------->int:" + JniUtils.getIntFromC(100));
        System.out.println("--------------------->byte:" + JniUtils.getByteFromC((byte) 128));
        System.out.println("--------------------->boolean:" + JniUtils.getBooleanFromC(true));
        System.out.println("--------------------->char:" + JniUtils.getCharFromC('a'));
        System.out.println("--------------------->short:" + JniUtils.getShortFromC((short) 1000));
        System.out.println("--------------------->long:" + JniUtils.getLongFromC(99999999L));
        System.out.println("--------------------->float:" + JniUtils.getFloatFromC(1000.00F));
        System.out.println("--------------------->double:" + JniUtils.getDoubleFromC(10000000000D));

        String[] test = {"hahah", "ehehe", "哈哈", "中", "今天天气很好"};
        String[] str = JniUtils.getStringArrayFromC(test);
        for (int i = 0; i < str.length; i++) {
            System.out.println("--------------------->" + str[i] + "\n");
        }

        int[] in_ = {10, 20, 30, 40, 50};
        int[] in_2 = JniUtils.getIntArrayFromC(in_);
        for (int i = 0; i < in_2.length; i++) {
            System.out.println("--------------------->" + in_2[i] + "\n");
        }

        byte[] bt_ = {(byte) 128, (byte) 129, (byte) 130, (byte) -129, (byte) -130};
        byte[] bt_2 = JniUtils.getByteArrayFromC(bt_);
        for (int i = 0; i < bt_2.length; i++) {
            System.out.println("--------------------->" + bt_2[i] + "\n");
        }

        try {
            char[] char_ = {'伟', 'B', 'C', 'D', 'E'};
            char[] char_2 = JniUtils.getCharArrayFromC(char_);
            for (int i = 0; i < char_2.length; i++) {
                // 中文显示还是有问题
                System.out.println("--------------------->" + new String(String.valueOf(char_2[i]).getBytes("ISO-8859-1"), "UTF-8") + "\n");
            }
        } catch (Exception e) {

        }

        boolean[] boolean_ = {true, false, true, false, true};
        boolean[] boolean_2 = JniUtils.getBooleanArrayFromC(boolean_);
        for (int i = 0; i < boolean_2.length; i++) {
            System.out.println("--------------------->" + boolean_2[i] + "\n");
        }

        Person person_ = new Person();
        person_.setName("伟弟");
        person_.setAge(30);
        Person person_2 = JniUtils.getObjectFromC(person_);
        if (person_2 != null) {
            System.out.println("--------------------->" + person_2.toString() + "\n");
        }

        Person person_3 = new Person();
        person_3.setName("张三");
        person_3.setAge(31);
        Person person_4 = new Person();
        person_4.setName("李四");
        person_4.setAge(32);
        Person person_5 = new Person();
        person_5.setName("王五");
        person_5.setAge(33);
        Person[] persons_ = {person_3, person_4, person_5};

        Person[] persons_2 = JniUtils.getObjectArrayFromC(persons_);
        if (persons_2 != null) {
            for (int i = 0; i < persons_2.length; i++) {
                System.out.println("--------------------->" + persons_2[i].toString() + "\n");
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
