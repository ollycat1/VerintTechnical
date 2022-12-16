import java.util.ArrayList;
import java.util.List;

public class Pages {
    public Pages()
    {
        // empty constructor
    }

    public List<Integer> getPages(int currentPage, int totalPagesOfResults, int numberOfPagesToDisplay)
    {
        inputValidation(currentPage, totalPagesOfResults, numberOfPagesToDisplay);
        List<Integer> pageList = new ArrayList<>(numberOfPagesToDisplay);
        int firstPage = getFirstPage(numberOfPagesToDisplay, currentPage);

        numberOfPagesToDisplay = firstPage + numberOfPagesToDisplay;
        for (int i = firstPage; i < numberOfPagesToDisplay; i++)
        {
            if (i <= totalPagesOfResults)
            {
                pageList.add(i);
            }
        }

        return pageList;
    }

    protected int getFirstPage(int numberOfPagesToDisplay, int currentPage)
    {
        int firstPage;
        if (numberOfPagesToDisplay % 2 == 0) {
            firstPage = getEvenFirstPage(currentPage, numberOfPagesToDisplay);
        } else {
            firstPage = getUnevenFirstPage(currentPage, numberOfPagesToDisplay);
        }
        return firstPage;
    }
    private int getEvenFirstPage(int currentPage, int numberOfPagesToDisplay)
    {
        if (currentPage < (numberOfPagesToDisplay / 2) + 2)
        {
            return 1;
        }
        if (currentPage )
        return currentPage - (numberOfPagesToDisplay / 2) + 1;
    }

    private int getUnevenFirstPage(int currentPage, int numberOfPagesToDisplay)
    {
        if (currentPage < ((numberOfPagesToDisplay / 2) - 1) + 2)
        {
            return 1;
        }
        return currentPage - ((numberOfPagesToDisplay - 1) / 2);
    }

    private void inputValidation(int currentPage, int totalPagesOfResults, int numberOfPagesToDisplay)
    {
        if (numberOfPagesToDisplay <= 0)
        {
            throw new IllegalArgumentException("The pages to display must be greater than 0");
        }
        if (currentPage > totalPagesOfResults)
        {
            throw new IllegalArgumentException("The current page cannot be higher than the total pages available");
        }
        if (currentPage <= 0)
        {
            throw new IllegalArgumentException("The current pages must be greater than 0");
        }
    }
}
