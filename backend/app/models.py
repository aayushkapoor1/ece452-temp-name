from pydantic import BaseModel
from typing import Optional


class StudySpotBase(BaseModel):
    name: str
    location: str
    description: Optional[str] = None


class StudySpotCreate(StudySpotBase):
    pass


class StudySpot(StudySpotBase):
    id: int

    class Config:
        from_attributes = True
