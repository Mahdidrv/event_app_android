package co.eventbox.tedxtehran.view.adapter

import android.content.Context
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.loadRadius
import co.eventbox.tedxtehran.utilities.toImageURL
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_gallery.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class GalleryAdapter : AdapterRecyclerView<DashboardCacheQuery.AlbumByOrganizer>(
    R.layout.row_gallery,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {

    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: DashboardCacheQuery.AlbumByOrganizer?
    ) {
        val itemView = viewHolder.itemView

        itemView.imgCover.loadRadius(element?.cover()?.toImageURL())
        itemView.txtTitle.text = element?.title()

    }

}