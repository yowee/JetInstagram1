package com.vipulasri.jetinstagram.ui.profile

import android.content.res.Configuration
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.PostsRepository
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.Post
import com.vipulasri.jetinstagram.model.Story
import com.vipulasri.jetinstagram.ui.components.DoubleTapPhotoLikeAnimation
import com.vipulasri.jetinstagram.ui.components.bottomBarHeight
import com.vipulasri.jetinstagram.ui.components.icon
import com.vipulasri.jetinstagram.ui.home.StoryImage
import com.vipulasri.jetinstagram.ui.theme.greyDark
import com.vipulasri.jetinstagram.ui.theme.ig_bt_color


@ExperimentalFoundationApi
@Composable
fun Profile() {
    val stories by StoriesRepository.observeStories()

    Scaffold(topBar = { com.vipulasri.jetinstagram.ui.components.Toolbar("Profile", R.drawable.back, R.drawable.elipsis ) }) {
        Column(modifier = Modifier.padding(10.dp)) {
            Divider()
            ProfileBarSection()
            UserProfileBio()
            StoriesSection(stories)
            Divider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Directions",
                modifier = Modifier.fillMaxWidth(1f),
                textAlign = TextAlign.Center,
                color = ig_bt_color,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Divider()
            PostBarHolder()

        }

    }

}


@Composable
fun ProfileBarSection() {
    Column(
        modifier = Modifier.padding(horizontal = 10.dp),
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row() {

            ProfilePicture(imageUrl = "image")

            Spacer(modifier = Modifier.width(15.dp))

            Column() {

                Row() {
                    Column(
                        modifier = Modifier
                            .weight(3f)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "371",
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            text = "posts",
                            color = greyDark,
                            style = MaterialTheme.typography.caption,
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(3.5f)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "14.4k",
                            style = MaterialTheme.typography.h6,
                        )
                        Text(
                            text = "followers",
                            color = greyDark,
                            style = MaterialTheme.typography.caption,
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(3.4f)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "272",
                            style = MaterialTheme.typography.h6,
                        )
                        Text(
                            text = "following",
                            style = MaterialTheme.typography.caption,
                            color = greyDark
                        )
                    }
                }

                Row(Modifier.fillMaxWidth(1f)) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = ig_bt_color),
                        modifier = Modifier
                            .height(35.dp)
                            .weight(5f)
                    ) {
                        Text(text = "Follow", color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(3.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = ig_bt_color),
                        modifier = Modifier
                            .width(30.dp)
                            .height(35.dp)
                            .weight(1f)
                    ) {
                        Image(
                            painterResource(id = R.drawable.sort_down),
                            contentDescription = "Cart button icon",
                        )
                    }
                }

            }
        }
    }

}

@Composable
fun UserProfileBio() {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = "Name",
            style = MaterialTheme.typography.h5
        )
        Text(text = "E-Commerce Website", color = greyDark)
        Text(
            text = "selective free resources for designers  @Unblast.",
            fontSize = 16.sp
        )
        Text(text = "Melbourne, Victoria, Australia")
    }
}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun ProfilePreview() {
    val stories by StoriesRepository.observeStories()

    Scaffold(topBar = { com.vipulasri.jetinstagram.ui.components.Toolbar("Profile", R.drawable.back, R.drawable.elipsis ) }) {
        Column(modifier = Modifier.padding(10.dp)) {
            Divider()
            ProfileBarSection()
            UserProfileBio()
            StoriesSection(stories)
            Divider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Directions",
                modifier = Modifier.fillMaxWidth(1f),
                textAlign = TextAlign.Center,
                color = ig_bt_color,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Divider()
            PostBarHolder()
        }

    }
}


@Composable
fun ProfilePicture(imageUrl: String) {
    val shape = CircleShape
    Box(
        modifier = Modifier
            .size(110.dp)
            .padding(6.dp)
            .background(color = Color.LightGray, shape = shape)
            .clip(shape)
    ) {
        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun StoriesSection(stories: List<Story>) {
    Column {
        StoriesList(stories)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun StoriesList(stories: List<Story>) {
    LazyRow {
        itemsIndexed(stories) { index, story ->

            if (index == 0) {
                Spacer(modifier = Modifier.width(6.dp))
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 6.dp)
            ) {
                StoryImage(imageUrl = story.image)
                Spacer(modifier = Modifier.height(5.dp))
                Text(story.name, style = MaterialTheme.typography.caption)
            }

            if (index == stories.size.minus(1)) {
                Spacer(modifier = Modifier.width(6.dp))
            }
        }
    }
}

@Composable
fun GridView() {

}


@Composable
fun PostBarHolder() {
    val posts by PostsRepository.posts
    val sectionState = remember { mutableStateOf(PostSection.Grid) }

    val navItems = PostSection.values()
        .toList()

    Scaffold(
        topBar = {
            PostBar(
                items = navItems,
                currentSection = sectionState.value,
                onSectionSelected = { sectionState.value = it },
            )
        }) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(
            modifier = modifier,
            targetState = sectionState.value
        )
        { section ->
            when (section) {
                PostSection.Grid -> GridPostView(posts.toList())
                PostSection.Single -> SinglePostView(posts.toList())
                PostSection.Private -> PrivatePostView()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SinglePostView(posts: List<Post>) {

    LazyColumn {

        itemsIndexed(posts) { _, post ->
            com.vipulasri.jetinstagram.ui.profile.Post(
               post
            )
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridPostView(posts: List<Post>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(4.dp) // Add padding between the posts
    ) {
        itemsIndexed(posts) { _, post ->
            Post(
                post = post
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun Post(
    post: Post
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(1.dp)
            .background(Color.LightGray) // Add a background color for visual separation
    ) {
        Image(
            painter = rememberImagePainter(post.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}



@Composable
fun PrivatePostView() {

}


@Composable
private fun PostBar(
    items: List<PostSection>,
    currentSection: PostSection,
    onSectionSelected: (PostSection) -> Unit,
) {
    TopAppBar(
        modifier = Modifier.height(bottomBarHeight),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background)
    ) {
        items.forEach { section ->

            val selected = section == currentSection

            val iconRes = if (selected) section.selectedIcon else section.icon

            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = iconRes),
                        modifier = Modifier.icon(),
                        contentDescription = ""
                    )
                },
                selected = selected,
                onClick = { onSectionSelected(section) },
                alwaysShowLabel = false
            )
        }
    }
}


private enum class PostSection(
    val icon: Int,
    val selectedIcon: Int
) {
    Grid(R.drawable.grid_empty, R.drawable.grid),
    Single(R.drawable.ic_outlined_reels, R.drawable.ic_filled_reels),
    Private(R.drawable.ic_outlined_add, R.drawable.ic_outlined_add),
}