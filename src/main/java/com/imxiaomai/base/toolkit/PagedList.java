package com.imxiaomai.base.toolkit;

import com.google.common.base.Function;
import com.imxiaomai.base._;

import java.util.List;

import static com.imxiaomai.base._.asList;
import static com.imxiaomai.base._.max;

public class PagedList<T> {

	public final int total;
	public final List<T> items;

	// 1=第一页
	public final int curPage;
	// >= 1
	public final int totalPages;
	// 每页条数
	public final int pageSize;

    /* ------------------------- init ------------------------- */

	public static <T> PagedList<T> of(int total, List<T> items, int curPage, int pageSize) {
		return new PagedList<T>(total, items, max(1, curPage), (total - 1) / pageSize + 1, pageSize);
	}
	public static <T> PagedList<T> ofOne(int total, T item, int curPage) {
		return new PagedList<T>(total, asList(item), max(1, curPage), total, 1);
	}
	public static <T> PagedList<T> ofEmpty(int curPage, int pageSize) {
		return new PagedList<T>(0, _.<T>emptyList(), max(1, curPage), max(1, curPage - 1), pageSize);
	}
	private PagedList(int total, List<T> items, int curPage, int totalPages, int pageSize) {
		this.total = total;
		this.items = items;
		this.curPage = curPage;
		this.totalPages = totalPages;
		this.pageSize = pageSize;
	}

    /* ------------------------- utils ------------------------- */

//	// 适用于：带编号目录展示
//	public PagedList<Pair<Integer, T>> zipWithIndex() {
//		final int[] last = {(curPage - 1) * pageSize};
//		return PagedList.of(total, CollUtil.mapNotNull(items, new Function<T, Pair<Integer, T>>() {
//			public Pair<Integer, T> apply(T t) {
//				return t == null ? null : Pair.of(++last[0], t);
//			}
//		}), curPage, pageSize);
//	}
//
//	// 适用于：带编号目录倒序
//	public PagedList<Pair<Integer, T>> zipWithReverseIndex() {
//		final int[] last = {total - (curPage - 1) * pageSize};
//		return PagedList.of(total, CollUtil.mapNotNull(items, new Function<T, Pair<Integer, T>>() {
//			public Pair<Integer, T> apply(T t) {
//				return t == null ? null : Pair.of(last[0]--, t);
//			}
//		}), curPage, pageSize);
//	}

	// 适用于，id列表转为entity列表等
	public <X> PagedList<X> mapNotNull(Function<T, X> mapper) {
		return of(this.total, CollUtil.mapNotNull(items, mapper), this.curPage, this.pageSize);
	}

}
