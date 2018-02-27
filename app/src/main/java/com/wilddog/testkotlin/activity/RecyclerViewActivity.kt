package com.wilddog.testkotlin.activity

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.wilddog.testkotlin.R
import com.wilddog.testkotlin.data.Task

import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.content_recycler_view.*
import kotlinx.android.synthetic.main.item_task_info.view.*

class RecyclerViewActivity : AppCompatActivity() {
    var list: MutableList<Task> = ArrayList<Task>()
    var adapter: TaskAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        genData()
        rv_task.layoutManager = LinearLayoutManager(this)
        adapter= TaskAdapter(this, list)
        rv_task.adapter = adapter
        adapter?.setOnItemClickListener(object: TaskAdapter.OnItemClickListener{
           override fun onItemClick(view: View, position: Int){
            var task = list.get(position)
               Toast.makeText(this@RecyclerViewActivity,task.id.toString()+task.des,Toast.LENGTH_SHORT).show()

           }
        })

    }

    fun genData() {
        for (i in 1..9) {
            var task = Task("every task", i, false)
            list.add(task)
        }
    }

    data class TaskAdapter constructor(var context: Context, var list: MutableList<Task>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
        var mContext: Context = context
        var mList: MutableList<Task> = list
        var mOnItemClickListener: OnItemClickListener? = null
        var mOnItemLongClickListener: OnItemLongClickListener? = null
        override fun getItemCount(): Int {
            return mList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.mView.setOnClickListener {
                    mOnItemClickListener?.onItemClick(holder.view, holder.layoutPosition)}
            holder.mView.setOnLongClickListener {
                    mOnItemLongClickListener?.onItemLongClick(holder.view, holder.layoutPosition)
                  true
            }
            var task = mList.get(position)
            holder.id.setText(task.id.toString())
            holder.des.setText(task.des)
            holder.isComplete.setText(task.isComplete.toString())
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            return ViewHolder(View.inflate(mContext, R.layout.item_task_info, null))
        }

        data class ViewHolder constructor(var view: View) : RecyclerView.ViewHolder(view) {
            var mss = view
            var mView: View = view
            var id: TextView = view.tv_id
            var des: TextView = view.tv_des
            var isComplete: TextView = view.tv_isComplete
        }

        fun setOnItemClickListener(listener: OnItemClickListener) {
            mOnItemClickListener = listener
        }

        fun setOnLongItemClickListener(listener: OnItemLongClickListener) {
            mOnItemLongClickListener = listener
        }

        interface OnItemClickListener {
            fun onItemClick(view: View, position: Int)
        }

        interface OnItemLongClickListener {
            fun onItemLongClick(view: View, position: Int)
        }
    }

}
