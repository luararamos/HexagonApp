package com.luaramartins.hexagonapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.luaramartins.hexagonapp.R
import com.luaramartins.hexagonapp.presentation.detailsview.PersonView
import com.luaramartins.hexagonapp.ui.theme.CORNER_RADIUS_16
import com.luaramartins.hexagonapp.ui.theme.ELEVATION_16
import com.luaramartins.hexagonapp.ui.theme.FONT_14
import com.luaramartins.hexagonapp.ui.theme.FONT_16
import com.luaramartins.hexagonapp.ui.theme.SMALL_PADDING

@Composable
fun CardPerson(
    person: PersonView
) {


    Card(
        modifier = Modifier
            .padding(horizontal = SMALL_PADDING, vertical = SMALL_PADDING)
            .shadow(
                elevation = ELEVATION_16,
                spotColor = Color.Black,
                shape = RoundedCornerShape(CORNER_RADIUS_16)
            )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    colorResource(id = R.color.colorWhite)
                )
                .padding(SMALL_PADDING)
        ) {
            val (
                imgPerson,
                name,
                age,
                inputName,
                inputAge,
            ) = createRefs()


            CircularImage(
                image = person.photo,
                modifier = Modifier
                    .constrainAs(ref = imgPerson) {
                        top.linkTo(parent.top, 0.dp)
                        start.linkTo(parent.start, 0.dp)
                        bottom.linkTo(parent.bottom, 0.dp)
                    }
            )

            Text(
                text = stringResource(id = R.string.person_name),
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_16,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = name) {
                        top.linkTo(parent.top, SMALL_PADDING)
                        start.linkTo(imgPerson.end, SMALL_PADDING)
                    }
            )
            Text(
                text = stringResource(id = R.string.person_age),
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = age) {
                        top.linkTo(name.bottom, SMALL_PADDING)
                        start.linkTo(imgPerson.end, SMALL_PADDING)
                    }
            )

            Text(
                text = person.name,
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_16,
                modifier = Modifier
                    .constrainAs(ref = inputName) {
                        top.linkTo(parent.top, SMALL_PADDING)
                        end.linkTo(parent.end, SMALL_PADDING)
                    }
            )
            Text(
                text = person.dateOfBirth,
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_14,
                modifier = Modifier
                    .constrainAs(ref = inputAge) {
                        top.linkTo(inputName.bottom, SMALL_PADDING)
                        end.linkTo(parent.end, SMALL_PADDING)
                    }
            )

        }
    }
}