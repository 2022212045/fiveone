import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fiveone.TodoItem
import com.example.fiveone.databinding.ListItemTodoBinding

class TodoAdapter(private val onTodoItemClick: (TodoItem) -> Unit) :
    ListAdapter<TodoItem, TodoAdapter.TodoViewHolder>(TodoItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ListItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todoItem = getItem(position)
        holder.bind(todoItem)
    }

    inner class TodoViewHolder(private val binding: ListItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnRemove.setOnClickListener {
                val todoItem = getItem(adapterPosition)
                onTodoItemClick(todoItem)
            }
        }

        fun bind(todoItem: TodoItem) {
            binding.tvTitle.text = todoItem.title
            binding.tvDescription.text = todoItem.description

            if (todoItem.completed) {
                binding.imgCompleted.visibility = View.VISIBLE
            } else {
                binding.imgCompleted.visibility = View.GONE
            }
        }
    }

    class TodoItemDiffCallback : DiffUtil.ItemCallback<TodoItem>() {
        override fun areItemsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
            return oldItem == newItem
        }
    }
}