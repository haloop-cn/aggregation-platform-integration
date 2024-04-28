package cn.haloop.intg.serializer.adapters;

import cn.haloop.intg.enums.Gender;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.util.Collection;
import java.util.Map;

/**
 * @author yangtuo
 */
public class AggAdapterFactory implements TypeAdapterFactory {


  @Override
  @SuppressWarnings("unchecked")
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (Gender.class == type.getRawType()) {
      return (TypeAdapter<T>) new GenderAdapter().nullSafe();
    }
    if (String.class == type.getRawType()) {
      return (TypeAdapter<T>) new StringAdapter().nullSafe();
    }
    if (Map.class.isAssignableFrom(type.getRawType())) {
      TypeAdapter<Object> delegateAdapter = (TypeAdapter<Object>) gson.getDelegateAdapter(this, type).nullSafe();
      return (TypeAdapter<T>) new MapAdapter(delegateAdapter).nullSafe();
    }
    if (Object[].class.isAssignableFrom(type.getRawType())) {
      TypeAdapter<Object[]> delegateAdapter = (TypeAdapter<Object[]>) gson.getDelegateAdapter(this, type).nullSafe();
      return (TypeAdapter<T>) new ArrayAdapter(delegateAdapter).nullSafe();
    }
    if (Collection.class.isAssignableFrom(type.getRawType())) {
      TypeAdapter<Collection<Object>> delegateAdapter = (TypeAdapter<Collection<Object>>) gson.getDelegateAdapter(this,
          type).nullSafe();
      return (TypeAdapter<T>) new CollectionAdapter(delegateAdapter).nullSafe();
    }

    return null;
  }
}
