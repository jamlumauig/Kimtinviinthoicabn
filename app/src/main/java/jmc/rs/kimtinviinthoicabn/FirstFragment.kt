package jmc.rs.kimtinviinthoicabn

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import jmc.rs.kimtinviinthoicabn.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val args = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        initialize()
        btnClick()
        return binding.root

    }

    fun initialize() {
        val top_curve_anim = AnimationUtils.loadAnimation(context, R.anim.top_down)
        binding.topCurve.startAnimation(top_curve_anim)

        val field_name_anim = AnimationUtils.loadAnimation(context, R.anim.field_name_anim)
        binding.logo.startAnimation(field_name_anim)

        val center_reveal_anim = AnimationUtils.loadAnimation(context, R.anim.center_reveal_anim)
        binding.btn1.startAnimation(center_reveal_anim)
        binding.btn2.startAnimation(center_reveal_anim)
        binding.btn3.startAnimation(center_reveal_anim)

        val new_user_anim = AnimationUtils.loadAnimation(context, R.anim.down_top)
        binding.text.startAnimation(new_user_anim)

    }

    fun btnClick() {
        binding.b1.setOnClickListener {
            args.putString("title", "btn1")
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, args)
        }
        binding.b2.setOnClickListener {
            args.putString("title", "btn2")
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, args)
        }
        binding.b3.setOnClickListener {
            args.putString("title", "btn3")
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, args)
        }
        binding.text.setOnClickListener{
            args.putString("title", "about")
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, args)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}