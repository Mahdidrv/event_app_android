package co.eventbox.tedxtehran.respository

import android.util.Log
import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.XException
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.co.eventbox.tedxtehran.CacheDataQuery

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class CacheDataRepository : Repository<CacheDataQuery.Data, Operation.Variables, CacheDataQuery>() {

    suspend fun request():Either<XException?,CacheDataQuery.Data?>{
        val response = fetch(CacheDataQuery.builder().build())

        response.fold({
            Log.d("TAG_AG","Error : ${it?.errorMessage} | code : ${it?.httpCode}")

        },{
            Log.d("TAG_AG","data : ${it?.organizer()?.albums()?.first()?.title()}")
        })

        return response
    }


}