package com.example.homework4

import android.app.ProgressDialog
import android.content.Context
import android.icu.text.DecimalFormat
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.sleep
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var downloadTask=DownloadTask(this)
        //绑定View
//        downloadTask.progressBar=progressBar//要动态修改的加载框
//        downloadTask.context=this//传入上下文 可以在downloadTask中显示toast
//        downloadTask.downloadHint=downloadHintText
        startBtn.setOnClickListener {
            //task智能被执行一次 再次点击会崩溃 这里可以做好判断
            downloadTask.execute()
        }
    }
}

//第一个参数是执行异步操作传入的参数 Unit表示不需要参数
//第二个参数是进度条表示
//第三个参数是异步操作结束后 返回的参数 这里是布尔型表示是否成功
class DownloadTask(context: Context) : AsyncTask<Unit,Int,Boolean>() {
    lateinit var dialog: ProgressDialog;
    var i: Int = 0;
    var context: Context? = null

    init {
        this.context = context;
    }
    var downloadHint: TextView?=null

    //任务执行之前开始调用此方法，可以在这里显示进度对话框。
    override fun onPreExecute() {
        super.onPreExecute()
        dialog = ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("任务正在执行中")
        dialog.setMessage("任务正在执行中，敬请等候...")
//            dialog.setButton("确定", new DialogInterface.OnClickListener() {


//            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMax(202);
        dialog.show();
    }


    //此方法在后台线程 执行，完成任务的主要工作，通常需要较长的时间。
    override fun doInBackground(vararg p0: Unit?): Boolean {
        i = 0;
        while (i < 202) {
            i = i + 1
            publishProgress(i)
            Thread.sleep(50);
//                dialog.setProgress((i / 100000) * 100);
//                dialog.progress = (i / 100000) * 100
//                Log.d(i+"")
        }
        return true
    }

    //更新UI
    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        values[0]?.let { dialog.setProgress(it) };
//            dialog.progress = (i / 10000) * 100
        //若有复杂逻辑，可以增加异常捕捉
    }

    //任务执行完了后执行
    override fun onPostExecute(result: Boolean?) {
        super.onPostExecute(result)
        if (result!!) {
//            downloadHint?.text="下载完成"
//        }else{
//            downloadHint?.text="下载失败"
//        }
//            dialog.dismiss()
//        Toast.makeText(context,"进程结束",Toast.LENGTH_LONG).show()
        }


