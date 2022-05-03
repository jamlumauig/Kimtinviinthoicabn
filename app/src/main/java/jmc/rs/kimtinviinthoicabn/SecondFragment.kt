package jmc.rs.kimtinviinthoicabn

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jmc.rs.kimtinviinthoicabn.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private lateinit var Sadapter: Adapter
    lateinit var rview: RecyclerView
    lateinit var text: TextView
    lateinit var about: TextView

    var title: String? = null

    private var arraylist: Array<String> = arrayOf()
    private var arraylist2: Array<String> = arrayOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        title = arguments?.getString("title")

        text = binding.registrationTitle
        about = binding.abouuuut
        rview = binding.recycler
        rview.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL,
            false
        )
        loadData()
        initialize()
        return binding.root

    }

    fun initialize() {
        val top_curve_anim = AnimationUtils.loadAnimation(context, R.anim.top_down)
        binding.topCurve.startAnimation(top_curve_anim)

        val field_name_anim = AnimationUtils.loadAnimation(context, R.anim.field_name_anim)
        text.startAnimation(field_name_anim)

        val center_reveal_anim = AnimationUtils.loadAnimation(context, R.anim.center_reveal_anim)
        rview.startAnimation(center_reveal_anim)

    }

    fun loadData() {
        Log.e("T I T L E", title.toString())

        val res: Resources = resources
        when (title) {
            "about" -> {
                text.setText(R.string.app_name)
                about.visibility = View.VISIBLE
            }
            "btn2" -> {
                text.setText(R.string.title_dashboard)
                about.visibility = View.GONE
                arraylist = res.getStringArray(R.array.warning)
                arraylist2 = res.getStringArray(R.array.warning2)

                for (value in arraylist) {
                    Sadapter = Adapter(arraylist, arraylist2)
                    rview.adapter = Sadapter
                }
            }
            "btn3" -> {
                text.setText(R.string.title_notifications)
                about.visibility = View.GONE
                arraylist = res.getStringArray(R.array.ways1)
                arraylist2 = res.getStringArray(R.array.ways2)

                for (value in arraylist) {
                    Sadapter = Adapter(arraylist, arraylist2)
                    rview.adapter = Sadapter
                }
            }

            "btn1" -> {
                text.setText(R.string.title_tips)
                about.visibility = View.GONE
                arraylist = res.getStringArray(R.array.tips1)
                arraylist2 = res.getStringArray(R.array.tips2)

                for (value in arraylist) {
                    Sadapter = Adapter(arraylist, arraylist2)
                    rview.adapter = Sadapter
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}