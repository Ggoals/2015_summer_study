#include <stdio.h>
#define false 0
#define true 1

int squre[101][101] = { { false, } };
int papernumber = 0;
int max = 0;

void check(int nX, int nY)
{
	int xstart = nX;
	int xend=nX;
	int ystart = nY;
	int yend = -1;
	int width = 0;
	int height = 0;
	int result = 0;
	int x, y;
	x = xstart;
	y = ystart;

	for (x = xstart; x <= 100; x++)
	{
		if (squre[x][y] == false)
		break;
		xend = x;
	}
	width = xend - xstart;
	if (width < 0)
		width = 0;
	for (x = xstart; x <= xend; x++)
	{
		for (y = ystart; y >= 0; y--)
		{
			if (squre[x][y] == false)
				break;
		}
		if (y > yend)
			yend = y;
	}
	if (yend == -1)
		yend = ystart;

	height = ystart - yend;//- 1;
	height--;

	if (height < 0)
		height = 0;

	result = width * height;

	if (result > max)
	{
		max = result;
	}
}

int main() {

	int i = 0;
	int nX = 0, nY = 0;
	int j = 0, k = 0;
	int fory, forx;

	scanf("%d", &papernumber);
	for (i = 0; i<papernumber; i++)
	{
		scanf("%d %d", &nX, &nY);
		for (j = nX; j <= nX + 10; j++)
		{
			for (k = nY; k <= nY + 10; k++)
			{
				squre[j][k] = true;
			}
		}
	}

	for (fory = 100; fory >= 0; fory--)
	{
		for (forx = 0; forx <= 100; forx++)
		{
				check(fory, forx);
		}
	}

	printf("%d\n", max);
	return 0;

}