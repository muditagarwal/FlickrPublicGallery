package com.example.flickrpublicgallery.view.fragment


import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.SearchViewBindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flickrpublicgallery.R
import com.example.flickrpublicgallery.databinding.PhotoGalleryFragmentBinding
import com.example.flickrpublicgallery.model.response.FeedItem
import com.example.flickrpublicgallery.network.model.Status
import com.example.flickrpublicgallery.utils.*
import com.example.flickrpublicgallery.view.ItemOffsetDecoration
import com.example.flickrpublicgallery.view.adapter.FeedItemListAdapter
import com.example.flickrpublicgallery.view.adapter.viewholder.FeedItemViewHolder
import com.example.flickrpublicgallery.viewmodel.FlickrGalleryViewModel
import com.example.flickrpublicgallery.viewmodel.factory.FlickrGalleryViewmodelFactory
import kotlinx.android.synthetic.main.fragment_photo_gallery.*
import kotlinx.android.synthetic.main.layout_photo_gallery.*

/**
 * A simple [Fragment] subclass.
 *
 */
class PhotoGalleryFragment : Fragment(), FeedItemViewHolder.ViewHolderListener {


    private lateinit var binding: PhotoGalleryFragmentBinding
    private lateinit var adapter: FeedItemListAdapter
    private var listener: Listener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo_gallery, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        binding.apply {
            viewmodel =
                ViewModelProvider(
                    activity!!,
                    FlickrGalleryViewmodelFactory(
                        Injection.provideFlickrGalleryRepository()
                    )
                )
                    .get(FlickrGalleryViewModel::class.java)
            setupObserver()
            viewmodel?.loadPhotos()
        }

        photos.layoutManager = LinearLayoutManager(activity!!)
        adapter = FeedItemListAdapter(listener = this)
        photos.addItemDecoration(
            ItemOffsetDecoration(
                activity,
                resources.getDimensionPixelOffset(R.dimen.gap_12)
            )
        )
        photos.adapter = adapter
    }

    private fun setupObserver() {
        binding.viewmodel?.getPhotoGalleryLiveData()?.observe(this) {
            it?.run {
                when (status) {
                    Status.ERROR -> binding.root.makeSnackBar(
                        throwable!!.getDisplayMessage()
                    )
                    Status.SUCCESS -> {
                        adapter.updateItems(data?.items ?: emptyList())
                    }
                }
            }
        }
    }

    override fun showDetails(
        feedItem: FeedItem,
        photoImageView: ImageView,
        titleTextView: TextView,
        publishedDateTextView: TextView
    ) {
        listener?.showDetails(feedItem, photoImageView, titleTextView, publishedDateTextView)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_photo_gallery, menu)
        setupSearch(menu)
    }

    private fun setupSearch(menu: Menu) {
        val searchMenu = menu.findItem(R.id.action_search)
        val searchView = searchMenu.actionView as SearchView
        searchView.queryHint = getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object :
            SearchViewBindingAdapter.OnQueryTextSubmit,
            SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query?.isNotBlank() == true) {
                    activity?.hideKeyboard()
                    binding.viewmodel?.loadPhotosForATag(query)
                    return true
                }
                return false
            }
        })

        searchMenu.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                binding.viewmodel?.resetSearch()
                return true
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sort_by_date_taken -> binding.viewmodel?.sortByDateTaken()
            R.id.action_sort_by_published_date -> binding.viewmodel?.sortByDatePublished()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Listener) {
            listener = context
        } else {
            throw RuntimeException("Implement PhotoGalleryFragment.Listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        fun newInstance() = PhotoGalleryFragment()
    }

    interface Listener {
        fun showDetails(
            feedItem: FeedItem,
            photoImageView: ImageView,
            titleTextView: TextView,
            publishedDateTextView: TextView
        )
    }

}
