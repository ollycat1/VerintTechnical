import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PagesTest {

    @Before
    public void init()
    {
        pages = new Pages();
        evenPageList = setUpEvenExpectedList();
        unevenPageList = setUpUnevenExpectedList();
    }

    // Public Methods
    @Test(expected = IllegalArgumentException.class)
    public void pages_currentPageIsBelowZero_inputValidation()
    {
        pages.getPages(currentPageNegative, totalPagesOfResults, numberOfPagesToDisplayEven);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pages_currentPageIsZero_inputValidation()
    {
        pages.getPages(currentPageZero, totalPagesOfResults, numberOfPagesToDisplayEven);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pages_currentPageIsHigherThanTotalPages_inputValidation()
    {
        pages.getPages(currentPageGreaterThanTotalPages, totalPagesOfResults, numberOfPagesToDisplayEven);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pages_badNumberOfPagesToDisplay_inputValidation()
    {
        pages.getPages(currentPage, totalPagesOfResults, numberOfPagesToDisplayZero);
    }

    @Test
    public void pages_evenNumberOfPagesToDisplay_getFirstPage()
    {
        int firstPage = pages.getFirstPage(numberOfPagesToDisplayEven, currentPage);
        assertEquals(firstPage, 11);
    }

    @Test
    public void pages_unevenNumberOfPagesToDisplay_getFirstPage()
    {
        int firstPage = pages.getFirstPage(numberOfPagesToDisplayUneven, currentPage);
        assertEquals(firstPage, 10);
    }

    @Test
    public void pages_returnsExpectedValuesEven_getPages()
    {
        List<Integer> pageList = pages.getPages(currentPage, totalPagesOfResults, numberOfPagesToDisplayEven);
        assertEquals(pageList, evenPageList);
    }

    @Test
    public void pages_returnsExpectedValuesUneven_getPages()
    {
        List<Integer> pageList = pages.getPages(currentPage, totalPagesOfResults, numberOfPagesToDisplayUneven);
        assertEquals(pageList, unevenPageList);
    }

    @Test
    public void pages_listDoesNotReturnNegativeValues_getPages()
    {
        List<Integer> pageList = pages.getPages(currentPageLowValue, totalPagesOfResults, numberOfPagesToDisplayUneven);
        int firstValueOfList = pageList.get(0);
        assertTrue(firstValueOfList >= 1);
    }

    @Test
    public void pages_listDoesNotExceedTotalPagesOfResults_getPages()
    {
        List<Integer> pageList = pages.getPages(currentPageHighValue, totalPagesOfResults, numberOfPagesToDisplayUneven);
        int finalValueOfList = pageList.get(5);
        assertTrue(finalValueOfList == 50);
    }

    // Private Methods
    private List<Integer> setUpEvenExpectedList()
    {
        return Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
    }

    private List<Integer> setUpUnevenExpectedList()
    {
        return Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
    }

    // Private Fields
    private Pages pages;
    private int totalPagesOfResults = 50;
    private int currentPage = 15;
    private int currentPageNegative = -1;
    private int currentPageGreaterThanTotalPages = 51;
    private int currentPageZero = 0;
    private int currentPageHighValue = 50;
    private int currentPageLowValue = 1;
    private int numberOfPagesToDisplayEven = 10;
    private int numberOfPagesToDisplayUneven = 11;
    private int numberOfPagesToDisplayZero = 0;
    private List<Integer> evenPageList;
    private List<Integer> unevenPageList;
}
