package den.ter.money.screens

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import den.ter.money.R
import den.ter.money.databinding.FragmentStartBinding
import kotlinx.android.synthetic.main.fragment_start.*
import kotlinx.android.synthetic.main.fragment_start.view.*


class StartFragment : Fragment() {

    var add_list = ArrayList<String>()

    lateinit var binding: FragmentStartBinding
    lateinit var rv: RecyclerView
    lateinit var adapter: StartAdapter
    lateinit var rv_add: RecyclerView
    lateinit var adapter_add: AddedAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        rv = binding.rvPop
        adapter = StartAdapter()
        rv.adapter = adapter
        rv_add = binding.rvAdded
        adapter_add = AddedAdapter()
        rv_add.adapter = adapter_add
        viewModel.getMoney()
        viewModel.myMoneyList.observe(viewLifecycleOwner, Observer{ list ->
            list.body()?.let { adapter.setList(it)
                binding.tvLoad.visibility = View.INVISIBLE
                binding.actual.text = "Актуальный курс на ${adapter.actual_date.substring(0,10)}"}

        })

        viewModel.getMoney()
        viewModel.myMoneyList.observe(viewLifecycleOwner, Observer{ list ->
            list.body()?.let { adapter_add.setList(it)}
        })

    }



}