package com.youknow.movie.ui.details

class DetailsPresenterTest {

//    @Mock
//    private lateinit var mockView: DetailsContract.View
//
//    @Mock
//    private lateinit var getMovie: GetMovie
//
//    private lateinit var detailsPresenter: DetailsViewModel
//
//    private lateinit var inOrder: InOrder
//    private lateinit var testScheduler: TestScheduler
//
//    private val mockMovieId = "mockId"
//    private val mockMovie = Movie(false, listOf("drama"),"homepage", 1, "overview", 1f, "path", "2019-03-01", 100, "release", "tagline", "title", 9.5f, 10)
//
//    @Before
//    fun setup() {
//        MockitoAnnotations.initMocks(this)
//
//        inOrder = Mockito.inOrder(mockView)
//
//        testScheduler = TestScheduler()
//        detailsPresenter = DetailsViewModel(mockView, getMovie, testScheduler, testScheduler)
//    }
//
//    @Test
//    fun `getMovie() 정상 케이스 - ProgressBar를 보여줬다가 영화의 상세 정보를 정상적으로 받아오면 ProgressBar를 가리고 상세 정보 보여줘야 한다`() {
//        `when`(getMovie.get(mockMovieId)).thenReturn(Single.just(mockMovie))
//
//        detailsPresenter.getMovie(mockMovieId)
//        testScheduler.triggerActions()
//
//        inOrder.verify(mockView).showProgressBar(View.VISIBLE)
//        inOrder.verify(mockView).hideError()
//        inOrder.verify(mockView).showProgressBar(View.GONE)
//        inOrder.verify(mockView).onMovieLoaded(mockMovie)
//    }
//
//    @Test
//    fun `getMovie() 예외 케이스 - 예외가 발생하면 에러 화면을 보여줘야 한다`() {
//        `when`(getMovie.get(mockMovieId)).thenReturn(Single.error(Exception()))
//
//        detailsPresenter.getMovie(mockMovieId)
//        testScheduler.triggerActions()
//
//        inOrder.verify(mockView).showProgressBar(View.VISIBLE)
//        inOrder.verify(mockView).hideError()
//        inOrder.verify(mockView).showProgressBar(View.GONE)
//        inOrder.verify(mockView).onError(R.string.err_get_movie_failed)
//    }
}