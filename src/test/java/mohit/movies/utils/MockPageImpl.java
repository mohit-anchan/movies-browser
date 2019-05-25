package mohit.movies.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 * A Mock implementation of Page interface for those methods that return paginated results.
 * Note: Only the top 4 methods have working logic, so avoid using all the lower methods.
 * Created by mohit on 11-May-19.
 */
public class MockPageImpl<U> implements Page<U> {
    private List<U> content;

    public MockPageImpl(List<U> content) {
        this.content = content;
    }

    @Override
    public List getContent() {
        return content;
    }

    @Override
    public long getTotalElements() {
        return getNumberOfElements();
    }

    @Override
    public int getNumberOfElements() {
        return (content == null) ? 0 : content.size();
    }

    @Override
    public boolean hasContent() {
        return (content != null);
    }

    /*  All the methods below have not been implemented */
    @Override
    public int getTotalPages() {
        return 0;
    }

    @Override
    public Page<U> map(Function function) {
        return null;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public boolean isFirst() {
        return false;
    }

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Pageable nextPageable() {
        return null;
    }

    @Override
    public Pageable previousPageable() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
