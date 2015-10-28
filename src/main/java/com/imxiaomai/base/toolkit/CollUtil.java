package com.imxiaomai.base.toolkit;

import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static com.imxiaomai.base._.emptyList;

public class CollUtil {

	public static <S, T> List<T> mapNotNull(Collection<S> src, Function<S, T> mapper) {
		List<T> trg = new ArrayList<>();
		for (S s : src) {
			T t = mapper.apply(s);
			if (t != null)
				trg.add(t);
		}
		return trg;
	}

	public static <T> List<List<T>> split(List<T> src, int cols) {
		if (src.size() <= 0) return emptyList();

		int fullRows = (src.size() - 1) / cols;
		List<List<T>> result = new ArrayList<>(fullRows + 1);
		for (int i = 0; i < fullRows; i++)
			result.add(src.subList(i * cols, (i + 1) * cols));
		result.add(src.subList(fullRows * cols, src.size()));
		return result;
	}

	public static <T> int count(Iterable<T> src, FilterFunction<T> filter){
		int count = 0;
		Iterator<T> iter = src.iterator();
		while (iter.hasNext()) {
			T nxt = iter.next();
			if (filter.filter(nxt))
				count ++;
		}
		return count;
	}

	public static <T> void filter(Iterable<T> src, FilterFunction<T> filter) {
		Iterator<T> iter = src.iterator();
		while (iter.hasNext()) {
			T nxt = iter.next();
			if (filter.filter(nxt))
				iter.remove();
		}
	}

	public interface FilterFunction<T> {
		public boolean filter(T t);
	}

}
