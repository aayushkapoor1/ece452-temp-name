"""Study spots API routes."""
from fastapi import APIRouter
from app.models import StudySpot, StudySpotCreate

router = APIRouter()

# In-memory store for demo; replace with DB later
spots_store: list[StudySpot] = []
_next_id = 1


@router.get("", response_model=list[StudySpot])
def list_spots():
    return spots_store


@router.post("", response_model=StudySpot)
def create_spot(spot: StudySpotCreate):
    global _next_id
    new_spot = StudySpot(id=_next_id, **spot.model_dump())
    _next_id += 1
    spots_store.append(new_spot)
    return new_spot


@router.get("/{spot_id}", response_model=StudySpot)
def get_spot(spot_id: int):
    for s in spots_store:
        if s.id == spot_id:
            return s
    from fastapi import HTTPException
    raise HTTPException(status_code=404, detail="Spot not found")
