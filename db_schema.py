'''This module defines the database schema for the application.

It uses SQLAlchemy with declarative mapping for defining tables.
'''

from sqlalchemy import create_engine, Column, Integer, String, DateTime, ForeignKey
from sqlalchemy.orm import relationship, declarative_base
from datetime import datetime


Base = declarative_base()


class User(Base):
    '''Represents a user in the system.
    '''
    __tablename__ = 'users'

    id = Column(Integer, primary_key=True, index=True)
    username = Column(String, unique=True, index=True, nullable=False)
    # In a real application, consider using a more secure way to store passwords
    # and handle hashing. This is a placeholder.
    email = Column(String, unique=True, index=True, nullable=False)
    password_hash = Column(
        String, nullable=False
    )  # Store hashed passwords, never plain text

    orders = relationship("Order", back_populates="user")


class Product(Base):
    '''Represents a product available for sale.
    '''
    __tablename__ = 'products'

    id = Column(Integer, primary_key=True, index=True)
    name = Column(String, index=True, nullable=False)
    description = Column(String, index=True)
    price = Column(Integer, nullable=False)  # Storing price as cents (integer) is safer

    orders = relationship("Order", back_populates="product")


class Order(Base):
    '''Represents an order placed by a user for a product.
    '''
    __tablename__ = 'orders'

    id = Column(Integer, primary_key=True, index=True)
    user_id = Column(Integer, ForeignKey("users.id"), nullable=False)
    product_id = Column(Integer, ForeignKey("products.id"), nullable=False)
    order_date = Column(DateTime, default=datetime.utcnow, nullable=False)
    quantity = Column(Integer, default=1, nullable=False)
    total_price = Column(Integer, nullable=False)  # Total price for this line item

    user = relationship("User", back_populates="orders")
    product = relationship("Product", back_populates="orders")


# Example of how to create the engine and tables (optional, for demonstration)
# Replace with your actual database URL
# DATABASE_URL = "sqlite:///./sql_app.db"
# engine = create_engine(DATABASE_URL)
# Base.metadata.create_all(bind=engine)

# You would typically use this Base object with a SQLAlchemy session
# in your application logic.
'''